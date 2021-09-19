package org.spring.bean.lifecycle;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @ClassName AnnotatedBeanDefintionParsingDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-17 15:35
 * @Version 1.0
 */
public class AnnotatedBeanDefinitionParsingDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);

        int beanDefinitionCountBefore = beanFactory.getBeanDefinitionCount();

        System.out.println(beanDefinitionCountBefore);

        beanDefinitionReader.register(AnnotatedBeanDefinitionParsingDemo.class);

        int beanDefinitionCountAfter = beanFactory.getBeanDefinitionCount();

        System.out.println(beanDefinitionCountAfter);

        AnnotatedBeanDefinitionParsingDemo demo = beanFactory.getBean("annotatedBeanDefinitionParsingDemo",
                AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(demo);
    }
}
