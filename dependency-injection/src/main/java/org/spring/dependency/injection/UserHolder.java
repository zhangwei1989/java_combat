package org.spring.dependency.injection;

import org.spring.ioc.overview.dependency.domain.User;

/**
 * @ClassName UserHolder
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 23:44
 * @Version 1.0
 */
public class UserHolder {

    private User user;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
