package dto;

/**
 * @Author jxx
 * @create 2020/7/8 3:40 下午
 */

/**
 * dto和dao类似，都是数据实体，但是dto是用于service和web间传输的，而dao用于数据库和service直接
 *
 * 暴露秒杀地址
 */
public class exposer {
    private boolean exposed;        //是否开启秒杀
    private String md5;     //一种加密措施
    private long oneShotId;
    private long now;      //系统当前时间
    private long start;
    private long end;

    public exposer(boolean exposed, String md5, long oneShotId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.oneShotId = oneShotId;
    }

    public exposer(boolean exposed, long oneShotId, long now, long start, long end) {
        this.exposed = exposed;
        this.oneShotId = oneShotId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public exposer(boolean exposed, long oneShotId) {
        this.exposed = exposed;
        this.oneShotId = oneShotId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getOneShotId() {
        return oneShotId;
    }

    public void setOneShotId(long oneShotId) {
        this.oneShotId = oneShotId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", oneShotId=" + oneShotId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
