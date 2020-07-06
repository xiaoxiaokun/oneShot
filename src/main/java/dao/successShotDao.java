package dao;

import entity.successShot;

/**
 * @Author jxx
 * @create 2020/7/5 4:48 下午
 */
public interface successShotDao {
    /**
     * 将秒杀商品和秒杀该商品的用户手机号插入库中
     * @param oneShotId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessShot(long oneShotId, long userPhone);


    /**
     * 根据商品id查找successShot并携带product
     * @param oneShotId
     * @return
     */
    successShot queryByIdWithProduct(long oneShotId);

}
