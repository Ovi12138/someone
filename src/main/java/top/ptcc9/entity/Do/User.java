package top.ptcc9.entity.Do;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-07 09:06:38
 */
@Data
@Accessors(chain = true)
public class User {
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
    @ApiModelProperty("自己地址  省")
    private String province;
    @ApiModelProperty("自己地址  市")
    private String city;
    @ApiModelProperty("自己地址  区")
    private String area;
    @ApiModelProperty("自己地址  省代码")
    private Integer provinceCode;
    @ApiModelProperty("自己地址  市代码")
    private Integer cityCode;
    @ApiModelProperty("自己地址  区代码")
    private Integer areaCode;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("微信号")
    private String wechatNum;
    @ApiModelProperty("意向群体最小年龄")
    private Integer targetMinAge;
    @ApiModelProperty("意向群体最大年龄")
    private Integer targetMaxAge;
    @ApiModelProperty("意向群体地址  省")
    private String targetProvince;
    @ApiModelProperty("意向群体地址  市")
    private String targetCity;
    @ApiModelProperty("意向群体地址  区")
    private String targetArea;
    @ApiModelProperty("意向群体地址  省代码")
    private Integer targetProvinceCode;
    @ApiModelProperty("意向群体地址  市代码")
    private Integer targetCityCode;
    @ApiModelProperty("意向群体地址  区代码")
    private Integer targetAreaCode;
    @ApiModelProperty("目标性别")
    private Integer targetGender;
    @ApiModelProperty("创建时间")
    private Long createTime;
}