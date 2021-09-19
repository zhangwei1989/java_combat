package org.spring.dependency.injection;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName XmlDependencySetterInjectionDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 23:39
 * @Version 1.0
 */
public class AnnotationDependencySetterInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(AnnotationDependencySetterInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(configApplicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";

        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        configApplicationContext.refresh();

        UserHolder userHolder = configApplicationContext.getBean(UserHolder.class);

        System.out.println(userHolder);

        configApplicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}
