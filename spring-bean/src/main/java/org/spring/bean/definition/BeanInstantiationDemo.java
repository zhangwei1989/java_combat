package org.spring.bean.definition;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanInstantiationDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 14:24
 * @Version 1.0
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-creation-context.xml");

        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryMethod = beanFactory.getBean("user-by-factory-bean", User.class);

        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryMethod);
    }
}
