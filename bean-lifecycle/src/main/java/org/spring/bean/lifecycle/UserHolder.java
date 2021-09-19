package org.spring.bean.lifecycle;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @ClassName UserHolder
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-17 21:48
 * @Version 1.0
 */
public class UserHolder implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware,
        EnvironmentAware, SmartInitializingSingleton {

    private final User user;

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    private String beanName;

    private Environment environment;

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UserHolder(User user) {
        this.user = user;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", classLoader=" + classLoader +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.number = 8;
        System.out.println("afterSingletonsInstantiated:" + number);
    }
}
