package org.spring.configuration.metadata;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @ClassName ExtensibleXmlAuthoringDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-18 22:53
 * @Version 1.0
 */
public class ExtensibleXmlAuthoringDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("META-INF/users-context.xml");

        User user = beanFactory.getBean(User.class);

        System.out.println(user);
    }
}
