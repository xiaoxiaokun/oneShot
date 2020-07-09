package service;

import dto.exposer;
import dto.oneShotExecution;
import entity.products;
import exception.repeatShotException;
import exception.shotCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author jxx
 * @create 2020/7/9 2:21 下午
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class oneShotServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private oneShotService oneShotService;

    @Test
    public void getProductsList() {
        List<products> list = oneShotService.getProductsList();
        for (products p : list)
            System.out.println(p.toString());
        logger.info("list={}", list);
    }

    @Test
    public void getById() {
        products products = oneShotService.getById(1000L);
        System.out.println(products.toString());
        logger.info("products={}", products);
    }

    //集成测试，整个秒杀逻辑
    @Test
    public void oneShotLogic() {
        long id = 1000L;
        exposer exposer = oneShotService.exportOneShotUrl(id);
        System.out.println(exposer.toString());
        if (exposer.isExposed()) {
            long phone = 19851993437L;
            String md5 = exposer.getMd5();

            try {
                oneShotExecution oneShotExecution = oneShotService.executeOneShot(id, phone, md5);
                System.out.println(oneShotExecution.toString());
            } catch (repeatShotException | shotCloseException e) {
                logger.error(e.getMessage());
                System.out.println(e.getMessage());
            }
        } else {
            logger.warn("exposer={}", exposer);
        }
    }
}