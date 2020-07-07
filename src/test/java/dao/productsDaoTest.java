package dao;

import entity.products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.*;
import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author jxx
 * @create 2020/7/7 1:48 上午
 */


/**
 * 配置Spring和junit的整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class productsDaoTest {

    //注入dao实现类依赖
    @Resource
    private productsDao productsDao;

    @Test
    public void reduceNumber() {
        long id = 1001;
        Date killTime = new Date();
        int res = productsDao.reduceNumber(id, killTime);
        System.out.println(res);
    }

    @Test
    public void queryById() {
        long id = 1000;
        products product = productsDao.queryById(id);
        System.out.println(product);
    }

    @Test
    public void queryAll() {
        List<products> products = productsDao.queryAll(0, 10);
        for (products p : products) {
            System.out.println(p.toString());
        }
    }
}