package entity;

import java.util.Date;

/**
 * @Author jxx
 * @create 2020/7/5 4:36 下午
 */
public class products {
    private long oneShotId;
    private String name;
    private int number;
    private Date startTime;
    private Date endTime;
    private Date createTime;

    public long getOneShotId() {
        return oneShotId;
    }

    public void setOneShotId(long oneShotId) {
        this.oneShotId = oneShotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "products{" +
                "oneShotId=" + oneShotId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}
