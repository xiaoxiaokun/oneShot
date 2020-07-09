package service.impl;

import dao.productsDao;
import dao.successShotDao;
import dto.exposer;
import dto.oneShotExecution;
import entity.products;
import entity.successShot;
import enums.oneShotStateEnum;
import exception.oneShotException;
import exception.repeatShotException;
import exception.shotCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import service.oneShotService;

import java.util.Date;
import java.util.List;

/**
 * @Author jxx
 * @create 2020/7/8 4:12 下午
 */

@Service
public class oneShotServiceImpl implements oneShotService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入service依赖
    @Autowired
    private productsDao productsDao;
    @Autowired
    private successShotDao successShotDao;

    final private String slat = "dIUSH$*(#@YHELFP*(#&$P#P:JSF:HuyYWEDS:>A";

    @Override
    public List<products> getProductsList() {
        return productsDao.queryAll(0, 100);
    }

    @Override
    public products getById(long oneShotId) {
        return productsDao.queryById(oneShotId);
    }

    @Override
    public exposer exportOneShotUrl(long oneShotId) {
        products products = productsDao.queryById(oneShotId);
        if (products == null) {
            return new exposer(false, oneShotId);
        }
        Date start = products.getStartTime();
        Date end = products.getEndTime();
        Date now = new Date();
        if (now.getTime() < start.getTime() || now.getTime() > end.getTime()) {
            return new exposer(false, oneShotId, now.getTime(), start.getTime(), end.getTime());
        }

        String md5 = getMD5(oneShotId); //TODO
        return new exposer(true, md5, oneShotId);
    }

    private String getMD5(long oneShotId) {
        String base = oneShotId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional
    /**
     * 使用注解控制事务方法的优点：
     * 1，开发团队达成一致
     * 2，保证事务执行时间尽可能短，不要穿插其他网络操作，如果有，剥离到事务方法外部
     * 3，不是所有方法都需要事务，如只有一条修改操作或只有只读操作就不需要
     */
    public oneShotExecution executeOneShot(long oneShotId, long userPhone, String md5) throws oneShotException, repeatShotException, shotCloseException {
        if (md5 == null || !getMD5(oneShotId).equals(md5)) {
            throw new oneShotException("oneShot data rewrite");
        }

        Date now = new Date();
        try {
            int updateCount = productsDao.reduceNumber(oneShotId, now);
            if (updateCount <= 0)
                throw new shotCloseException("shot is closed");
            else {
                int insertCount = successShotDao.insertSuccessShot(oneShotId, userPhone);
                if (insertCount <= 0) {
                    throw new repeatShotException("oneShot repeat");
                } else {
                    successShot successShot = successShotDao.queryByIdWithProduct(oneShotId, userPhone);
                    return new oneShotExecution(oneShotId, oneShotStateEnum.SUCCESS, successShot);
                }
            }
        }catch (repeatShotException e1) {
            throw e1;
        }catch (shotCloseException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new oneShotException("oneShot inner error: " + e.getMessage());
        }
    }
}
