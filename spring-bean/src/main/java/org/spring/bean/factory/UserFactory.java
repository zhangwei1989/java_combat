package org.spring.bean.factory;

import org.spring.ioc.overview.dependency.domain.User;

/**
 * @ClassName UserFactory
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 14:28
 * @Version 1.0
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }
}
