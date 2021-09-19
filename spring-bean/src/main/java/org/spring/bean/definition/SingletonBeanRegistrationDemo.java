package org.spring.bean.definition;

import org.spring.bean.factory.DefaultUserFactory;
import org.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SingletonBeanRegistrationDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 15:46
 * @Version 1.0
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        UserFactory userFactory = new DefaultUserFactory();
        System.out.println(userFactory);
        ConfigurableListableBeanFactory beanFactory = configApplicationContext.getBeanFactory();
        beanFactory.registerSingleton("userFactory", userFactory);
        configApplicationContext.refresh();

        UserFactory userFactory1 = configApplicationContext.getBean(UserFactory.class);
        System.out.println(userFactory1);
        System.out.println(userFactory == userFactory1);

        configApplicationContext.close();
    }
}
