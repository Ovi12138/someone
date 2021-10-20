package top.ptcc9.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-08 08:55:31
 */
@ApiModel("通用返回实体")
@Data
public class CommonResult<T> {
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("消息")
    private String message;
    @ApiModelProperty("数据")
    private T data;

    private CommonResult(State state, T data) {
        this.code = state.code;
        this.message = state.message;
        this.data = data;
    }

    public static <T> CommonResult<T> build(State state, T t) {
        return new CommonResult<>(state,t);
    }

    public static <T> CommonResult<T> build(State state) {
        return build(state,null);
    }
}
