package org.spring.ioc.overview.container;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @ClassName BeanFactoryIocContainerDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-09 18:50
 * @Version 1.0
 */
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AnnotationApplicationContextAsIocContainerDemo.class);

        lookupCollectionByType(configApplicationContext);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("zhangwei");

        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有 User 集合对象： " + users);
        }
    }
}
