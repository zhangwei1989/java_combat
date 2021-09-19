package org.spring.ioc.overview.dependency.injection;

import org.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName DependencyLookupDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-08 23:10
 * @Version 1.0
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");

        System.out.println(userRepository.getUsers());

        System.out.println(userRepository.getBeanFactory());
        System.out.println(beanFactory);
        System.out.println(userRepository.getBeanFactory() == beanFactory);
    }

}
