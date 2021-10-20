package top.ptcc9.mapstruct.user;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import top.ptcc9.entity.Do.User;
import top.ptcc9.entity.Vo.Address;

/**
 * @Author HE LONG CAN
 * @Description 映射规则
 * @Date 2021-10-14 16:05:59
 */
@Mapper(componentModel = "spring")
public class UserDvoRule {

    /**
     * 转换为自己的地址
     * @param user
     * @return Address
     */
    @Named("convert2Address")
    public Address convert2Address(User user) {
        String province = user.getProvince();
        String city = user.getCity();
        String area = user.getArea();
        Integer provinceCode = user.getProvinceCode();
        Integer cityCode = user.getCityCode();
        Integer areaCode = user.getAreaCode();
        return new Address()
                .setProvince(province)
                .setCity(city)
                .setArea(area)
                .setProvinceCode(provinceCode)
                .setCityCode(cityCode)
                .setAreaCode(areaCode);
    }


    /**
     * 转换为目标群体地址
     * @param user
     * @return Address
     */
    @Named("convert2TargetAddress")
    public Address convert2TargetAddress(User user) {
        String province = user.getTargetProvince();
        String city = user.getTargetCity();
        String area = user.getTargetArea();
        Integer provinceCode = user.getTargetProvinceCode();
        Integer cityCode = user.getTargetCityCode();
        Integer areaCode = user.getTargetAreaCode();
        return new Address()
                .setProvince(province)
                .setCity(city)
                .setArea(area)
                .setProvinceCode(provinceCode)
                .setCityCode(cityCode)
                .setAreaCode(areaCode);
    }
}
