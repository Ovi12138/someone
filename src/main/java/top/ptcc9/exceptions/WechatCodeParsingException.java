package top.ptcc9.exceptions;

/**
 * @Author HE LONG CAN
 * @Description 小程序给定的code解析openId失败
 * @Date 2021-10-14 09:45:25
 */
public class WechatCodeParsingException extends Exception{
    public WechatCodeParsingException() {
    }

    public WechatCodeParsingException(String message) {
        super(message);
    }
}
