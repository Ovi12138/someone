package top.ptcc9.common;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-08 08:56:00
 */
public enum State {
    SUCCESS(200,"success"),


    //解析openId时出错
    ERROR_OPENID_PARSING(401,"解析openId时出错")
    ;

    Integer code;
    String message;

    State(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
