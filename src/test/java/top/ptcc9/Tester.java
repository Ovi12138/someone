package top.ptcc9;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.ptcc9.entity.Do.User;
import top.ptcc9.entity.Vo.UserVo;
import top.ptcc9.mapper.UserMapper;
import top.ptcc9.mapstruct.user.UserDvoMapper;

import javax.annotation.Resource;

/**
 * @Author HE LONG CAN
 * @Description TODO
 * @Date 2021-10-14 08:53:22
 */
@SpringBootTest
public class Tester {

    @Resource
    UserMapper userMapper;

    @Resource
    UserDvoMapper userDvoMapper;

    /**
     * 这个测试临时使用
     */
    @Test
    void test() {
        String str = IdUtil.simpleUUID();
        System.out.println("str.length() = " + str.length());
    }

    /**
     * 测试第一个xml sql
     */
    @Test
    void test01() {
        User test = userMapper.getUserById("TEST");
        System.out.println("test = " + test);
    }

    /**
     * 测试新建用户啊
     */
    @Test
    void test02() {
        User user = new User();
        user.setId("TEST1");
        user.setInviteCode("TEST1");
        user.setCreateTime(Long.parseLong(DateUtil.now().replaceAll("[- :]","")));
        userMapper.insertRegister(user);
    }

    /**
     * 测试 mapstruct
     */
    @Test
    void test03() {
        User user = new User()
                .setProvince("陕西省")
                .setCity("咸阳市")
                .setArea("秦都区")
                .setProvinceCode(610000)
                .setCityCode(610400)
                .setAreaCode(610402);
        UserVo userVo = userDvoMapper.user2Vo(user);
        System.out.println("userVo = " + userVo);
    }
}
