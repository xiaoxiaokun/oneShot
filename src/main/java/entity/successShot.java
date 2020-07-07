package entity;

import java.util.Date;

/**
 * @Author jxx
 * @create 2020/7/5 4:39 下午
 */
public class successShot {
    private long oneShotId;
    private long userPhone;
    private Date createTime;
    private short state;

    //多对一
    private products products;

    public products getProducts() {
        return products;
    }

    public void setProducts(products products) {
        this.products = products;
    }

    public long getOneShotId() {
        return oneShotId;
    }

    public void setOneShotId(long oneShotId) {
        this.oneShotId = oneShotId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "successShot{" +
                "oneShotId=" + oneShotId +
                ", userPhone=" + userPhone +
                ", createTime=" + createTime +
                ", state=" + state +
                ", products=" + products +
                '}';
    }
}
