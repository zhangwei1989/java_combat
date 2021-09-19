package org.spring.bean.lifecycle;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanInstantiationLifecycleDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-17 18:59
 * @Version 1.0
 */
public class BeanInitializationLifecycleDemo {

    public static void main(String[] args) {
        executeBeanFactory();

    }

    public static void executeBeanFactory() {
        DefaultListableBeanFactory beanFactory =  new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};
        xmlBeanDefinitionReader.loadBeanDefinitions(locations);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);

        beanFactory.preInstantiateSingletons();

        System.out.println(userHolder);
    }

}

