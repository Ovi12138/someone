package top.ptcc9.config;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @Author HE LONG CAN
 * @Description 生成规则
 * @Date 2021-04-20 12:51:39
 */
@Component
public class MyBatisPlusIdGenerator implements IdentifierGenerator, MetaObjectHandler {
    @Override
    public Number nextId(Object entity) {
        return null;
    }

    @Override
    public String nextUUID(Object entity) {
        return null;
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        int createTime = Integer.parseInt(DateUtil.now().replaceAll("[- :]",""));
        metaObject.setValue("createTime", createTime);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
    }
}
