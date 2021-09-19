package org.spring.bean.lifecycle;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @ClassName MergedBeanDefinitionDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-17 18:15
 * @Version 1.0
 */
public class MergedBeanDefinitionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory =  new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String location = "META-INF/dependency-lookup-context.xml";
        Resource resource = new ClassPathResource(location);

        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        xmlBeanDefinitionReader.loadBeanDefinitions(encodedResource);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);
    }
}
