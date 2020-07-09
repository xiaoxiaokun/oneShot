package service;

/**
 * @Author jxx
 * @create 2020/7/8 3:32 下午
 */


import dto.exposer;
import dto.oneShotExecution;
import entity.products;
import exception.oneShotException;
import exception.repeatShotException;
import exception.shotCloseException;

import java.util.List;

/**
 * 业务接口，站在使用者角度
 * 1，方法定义粒度 2，参数 3，返回类型
 */
public interface oneShotService {
    //查询所有秒杀记录
    List<products> getProductsList();

    //查询单个秒杀记录
    products getById(long oneShotId);

    //输出秒杀接口地址，如果秒杀未开启，输出系统时间和秒杀开启结束时间
    exposer exportOneShotUrl(long oneShotId);

    //执行秒杀操作
    oneShotExecution executeOneShot(long oneShotId, long userPhone, String md5)
    throws oneShotException, repeatShotException, shotCloseException;
}
