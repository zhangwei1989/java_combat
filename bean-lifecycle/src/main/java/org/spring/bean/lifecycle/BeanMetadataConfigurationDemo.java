package org.spring.bean.lifecycle;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * @ClassName BeanMetadataConfigurationDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-17 14:14
 * @Version 1.0
 */
public class BeanMetadataConfigurationDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/user.properties";
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(location);

        System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);

        User user = beanFactory.getBean("user", User.class);

        System.out.println(user);
    }
}
