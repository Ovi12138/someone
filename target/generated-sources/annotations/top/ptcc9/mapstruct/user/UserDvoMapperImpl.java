package top.ptcc9.mapstruct.user;

import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.ptcc9.entity.Do.User;
import top.ptcc9.entity.Vo.UserVo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-20T10:29:29+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class UserDvoMapperImpl implements UserDvoMapper {

    @Autowired
    private UserDvoRule userDvoRule;

    @Override
    public UserVo user2Vo(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo userVo = new UserVo();

        userVo.setAddress( userDvoRule.convert2Address( user ) );
        userVo.setTargetAddress( userDvoRule.convert2TargetAddress( user ) );
        userVo.setId( user.getId() );
        userVo.setCoupon( user.getCoupon() );
        userVo.setIsLining( user.getIsLining() );
        userVo.setIsNew( user.getIsNew() );
        userVo.setInviteCode( user.getInviteCode() );
        userVo.setGender( user.getGender() );
        userVo.setAge( user.getAge() );
        userVo.setWechatNum( user.getWechatNum() );
        userVo.setTargetGender( user.getTargetGender() );
        userVo.setCreateTime( user.getCreateTime() );

        return userVo;
    }
}
