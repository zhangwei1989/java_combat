package org.spring.bean.factory;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName UserFactoryBean
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 14:37
 * @Version 1.0
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
