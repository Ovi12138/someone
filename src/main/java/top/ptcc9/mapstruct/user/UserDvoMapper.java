package top.ptcc9.mapstruct.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import top.ptcc9.entity.Do.User;
import top.ptcc9.entity.Vo.UserVo;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-14 16:05:52
 */
@Mapper(componentModel = "spring",uses = {UserDvoRule.class})
public interface UserDvoMapper {

    /**
     * user => userVo
     * @param user
     * @return UserVo
     */
    @Mapping(source = "user",target = "address",qualifiedByName = "convert2Address")
    @Mapping(source = "user",target = "targetAddress",qualifiedByName = "convert2TargetAddress")
    UserVo user2Vo(User user);
}
