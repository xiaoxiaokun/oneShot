package enums;

/**
 * @Author jxx
 * @create 2020/7/9 2:30 上午
 */
public enum  oneShotStateEnum {
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_ONESHOT(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统错误"),
    DATA_REWRITE(-3, "数据篡改");


    private int state;
    private String stateInfo;

    oneShotStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static oneShotStateEnum stateOf(int index) {
        for (oneShotStateEnum state:values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
