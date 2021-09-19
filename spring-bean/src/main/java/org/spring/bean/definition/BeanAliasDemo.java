package org.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanAliasDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 13:14
 * @Version 1.0
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        System.out.println(beanFactory.getBean("zhangwei"));
    }
}
