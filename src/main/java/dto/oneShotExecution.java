package dto;

import entity.successShot;
import enums.oneShotStateEnum;

/**
 * @Author jxx
 * @create 2020/7/8 3:48 下午
 */
public class oneShotExecution {
    private long oneShotId;
    private int state;      //执行秒杀结果状态
    private String stateInfo;       //状态含义
    private successShot successShot;    //秒杀成功对象

    //成功的话
    public oneShotExecution(long oneShotId, oneShotStateEnum oneShotStateEnum, entity.successShot successShot) {
        this.oneShotId = oneShotId;
        this.state = oneShotStateEnum.getState();
        this.stateInfo = oneShotStateEnum.getStateInfo();
        this.successShot = successShot;
    }
    //失败的话
    public oneShotExecution(long oneShotId, oneShotStateEnum oneShotStateEnum) {
        this.oneShotId = oneShotId;
        this.state = oneShotStateEnum.getState();
        this.stateInfo = oneShotStateEnum.getStateInfo();
    }

    public long getOneShotId() {
        return oneShotId;
    }

    public void setOneShotId(long oneShotId) {
        this.oneShotId = oneShotId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public entity.successShot getSuccessShot() {
        return successShot;
    }

    public void setSuccessShot(entity.successShot successShot) {
        this.successShot = successShot;
    }

    @Override
    public String toString() {
        return "oneShotExecution{" +
                "oneShotId=" + oneShotId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successShot=" + successShot +
                '}';
    }
}
