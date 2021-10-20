package top.ptcc9.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.aliyun.oss.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.ptcc9.entity.Do.User;
import top.ptcc9.entity.Vo.UserVo;
import top.ptcc9.exceptions.WechatCodeParsingException;
import top.ptcc9.mapper.UserMapper;
import top.ptcc9.mapstruct.user.UserDvoMapper;
import top.ptcc9.service.WechatLoginService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.annotation.Resource;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-11 16:38:15
 */
@Service(value = "WechatLoginServiceImpl")
public class WechatLoginServiceImpl implements WechatLoginService {
    private static final Log log = LogFactory.get(WechatLoginServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserDvoMapper userDvoMapper;

    @Value("${appid}")
    private String appId;

    @Value("${appsecret}")
    private String appSecret;


    @Override
    public String getOpenId(String code) throws WechatCodeParsingException {
        log.info("appid:{},appsecret:{},code:{}",appId,appSecret,code);
        StringBuilder requestUrl = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        requestUrl.append("appid=");
        requestUrl.append(appId);
        requestUrl.append("&secret=");
        requestUrl.append(appSecret);
        requestUrl.append("&js_code=");
        requestUrl.append(code);
        requestUrl.append("&grant_type=authorization_code");
        String openid = "";
        try{
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(requestUrl.toString());
            HttpResponse response = client.execute(get);
            HttpEntity result = response.getEntity();
            String content = EntityUtils.toString(result);
            JSONObject jsonObject = JSONUtil.parseObj(content);
            log.info("得到解析后的json字符串:{}",jsonObject.toString());
            openid = (String) jsonObject.get("openid");
        }catch (Exception e){
            log.error("网络请求解析openId时出错");
            e.printStackTrace();
        }


        //解析失败时的操作
        if (StringUtils.isNullOrEmpty(openid)) {
            log.error("解析openId时出错");
            throw new WechatCodeParsingException();
        }
        return openid;
        //olr9-5f6iaz0p7uw0wPgJ_FivR4U
    }

    @Override
    public UserVo doLogin(String openId) {
        User user = userMapper.getUserById(openId);
        if (user == null) {
            log.info("该用户openId:{}未注册，开始注册",openId);
            return doSignUp(openId);
        }
        return userDvoMapper.user2Vo(user);
    }

    private UserVo doSignUp(String openId) {
        User user = new User()
                .setId(openId)
                .setInviteCode(IdUtil.simpleUUID())
                .setCreateTime(Long.parseLong(DateUtil.now().replaceAll("[- :]", "")));
        userMapper.insertRegister(user);
        return userDvoMapper.user2Vo(user);
    }


}
