package org.spring.ioc.overview.repository;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;

import java.util.Collection;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-09 00:08
 * @Version 1.0
 */
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
