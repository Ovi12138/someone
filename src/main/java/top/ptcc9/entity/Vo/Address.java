package top.ptcc9.entity.Vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author HE LONG CAN
 * @Description 地址  省市区
 * @Date 2021-10-11 09:39:43
 */
@Data
@Accessors(chain = true)
public class Address {
    @ApiModelProperty("省")
    private String province;
    @ApiModelProperty("市")
    private String city;
    @ApiModelProperty("区")
    private String area;
    @ApiModelProperty("省代码")
    private Integer provinceCode;
    @ApiModelProperty("市代码")
    private Integer cityCode;
    @ApiModelProperty("区代码")
    private Integer areaCode;
}
