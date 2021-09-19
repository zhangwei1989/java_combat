package org.spring.bean.lifecycle;

import org.spring.ioc.overview.dependency.domain.SuperUser;
import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName BeanInstantiationLifecycleDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-17 18:59
 * @Version 1.0
 */
public class BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {
        executeBeanFactory();

        System.out.println("-----------------------------------------");
        executeApplicationContext();
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
    }

    public static void executeApplicationContext() {
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext();
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};

        applicationContext.setConfigLocations(locations);

        applicationContext.refresh();

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        User superUser = applicationContext.getBean("superUser", User.class);
        System.out.println(superUser);

        UserHolder userHolder = applicationContext.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);

        applicationContext.close();
    }


}

