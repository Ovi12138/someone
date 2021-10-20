package top.ptcc9.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.ptcc9.common.CommonResult;

import static top.ptcc9.common.State.ERROR_OPENID_PARSING;

/**
 * @Author HE LONG CAN
 * @Description 全局捕获
 * @Date 2021-10-14 09:44:20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WechatCodeParsingException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public CommonResult<String> wechatCodeParsingException(WechatCodeParsingException e) {
        return CommonResult.build(ERROR_OPENID_PARSING);
    }
}
