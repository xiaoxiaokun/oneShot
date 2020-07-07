package dao;

import entity.products;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author jxx
 * @create 2020/7/5 4:44 下午
 */
public interface productsDao {
    /**
     * 秒杀后减少对应商品的库存
     * @param oneShotId
     * @param killTime
     * @return 如果行数>1，表示更新的记录行数
     */
    int reduceNumber(@Param("oneShotId") long oneShotId, @Param("killTime") Date killTime);

    /**
     * 根据商品ID查找秒杀对象
     * @param oneShotId
     * @return
     */
    products queryById(long oneShotId);

    /**
     * 根据偏移量按序查找指定数量的秒杀商品
     * @param offset
     * @param limit
     * @return
     */
    List<products> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
