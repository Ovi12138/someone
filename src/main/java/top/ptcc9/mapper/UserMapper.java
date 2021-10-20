package top.ptcc9.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.ptcc9.entity.Do.User;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-11 16:38:31
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 插入一个用户
     * @param user
     * @return int 影响条数
     */
    int insertRegister(User user);


    /**
     * 根据 openId 获取一个用户
     * @param id
     * @return User
     */
    User getUserById(String id);


}
