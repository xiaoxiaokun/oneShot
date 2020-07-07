package dao;

import entity.successShot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author jxx
 * @create 2020/7/7 5:38 下午
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class successShotDaoTest {

    @Resource
    private successShotDao successShotDao;

    @Test
    public void insertSuccessShot() {
        int res = successShotDao.insertSuccessShot(1001L, 13851993427L);
        System.out.println("插入：" + res + "行");
    }

    @Test
    public void queryByIdWithProduct() {
        successShot successShot = successShotDao.queryByIdWithProduct(1001L, 13851993427L);

        System.out.println(successShot);
        System.out.println(successShot.getProducts());
    }
}