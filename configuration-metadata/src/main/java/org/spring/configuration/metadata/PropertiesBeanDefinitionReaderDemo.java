package org.spring.configuration.metadata;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * @ClassName PropertiesBeanDefinitionReaderDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-18 21:22
 * @Version 1.0
 */
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions("META-INF/users-beans-config.properties");
        System.out.println(String.format("已加载 %s 个 BeanDefinition \n", beanDefinitionCount));

        User user = beanFactory.getBean(User.class);

        System.out.println(user);
    }
}
