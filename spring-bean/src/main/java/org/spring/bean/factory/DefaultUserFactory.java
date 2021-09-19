package org.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName DefaultUserFactory
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 14:30
 * @Version 1.0
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("UserFactory 初始化中 ...");
    }

    public void initUserFactory() {
        System.out.println("自定义初始化方法 UserFactory 初始化中 ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 初始化方法 UserFactory 初始化中 ...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("UserFactory 销毁中 ...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 销毁方法 UserFactory 初始化中 ...");
    }

    public void destroyUserFactory() {
        System.out.println("自定义销毁方法 UserFactory 销毁中 ...");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("正在回收中 ...");
    }
}
