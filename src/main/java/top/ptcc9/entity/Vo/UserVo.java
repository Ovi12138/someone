package top.ptcc9.entity.Vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-11 16:30:51
 */
@Data
public class UserVo {
    @ApiModelProperty("小程序用户openId")
    private String id;
    @ApiModelProperty("交换卷数量")
    private Integer coupon;
    @ApiModelProperty("是否正在排队  1:yes   0:no")
    private Integer isLining;
    @ApiModelProperty("是否新用户  1:yes  0:no")
    private Integer isNew;
    @ApiModelProperty("邀请码 每次使用后更换")
    private String inviteCode;
    @ApiModelProperty("性别  1:男   0:女")
    private Integer gender;
    @ApiModelProperty("自己地址")
    private Address address;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("微信号")
    private String wechatNum;
    @ApiModelProperty("意向群体地址")
    private Address targetAddress;
    @ApiModelProperty("意向群体性别")
    private Integer targetGender;
    @ApiModelProperty("创建时间")
    private Long createTime;
}
