package top.ptcc9.service;

import top.ptcc9.entity.Vo.UserVo;
import top.ptcc9.exceptions.WechatCodeParsingException;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-11 09:35:03
 */
public interface WechatLoginService {
    /**
     * 根据 小程序 参数 code 解析 openId
     * @param code
     * @return
     * @throws WechatCodeParsingException openId可能解析异常
     */
    String getOpenId(String code) throws WechatCodeParsingException;

    /**
     * 小程序登录
     * @param openId
     * @return
     */
    UserVo doLogin(String openId);
}
