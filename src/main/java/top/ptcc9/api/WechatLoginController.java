package top.ptcc9.api;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import top.ptcc9.common.CommonResult;
import top.ptcc9.entity.Vo.UserVo;
import top.ptcc9.exceptions.WechatCodeParsingException;
import top.ptcc9.service.WechatLoginService;

import javax.annotation.Resource;

import static top.ptcc9.common.State.SUCCESS;

/**
 * @Author HE LONG CAN
 * @Description 小程序登录
 * @Date 2021-10-11 09:32:20
 */
@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(origins = "*",maxAge = 3600)
public class WechatLoginController {
    private static final Log log = LogFactory.get(WechatLoginController.class);

    @Qualifier("WechatLoginServiceImpl")
    @Resource
    private WechatLoginService wechatLoginService;

    @ApiOperation(value = "登录，含注册",notes = "通过openId判断是否已注册，若已注册直接登录，未注册则注册",responseContainer = "CommonResult",response = UserVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "code",
                    dataType = "String",
                    required = true,
                    value = "小程序res.code"
            )
    })
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public CommonResult<UserVo> doLogin(@RequestBody String code) throws WechatCodeParsingException {
        String openId = wechatLoginService.getOpenId(code);
        log.info("用户登录获取openId:{}",openId);
        UserVo userVo = wechatLoginService.doLogin(openId);
        return CommonResult.build(SUCCESS,userVo);
    }
}
