package org.spring.dependency.injection;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

/**
 * @ClassName XmlDependencySetterInjectionDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 23:39
 * @Version 1.0
 */
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    private ObjectProvider<User> userObjectProvider;

    @Autowired
    private ObjectProvider<Collection<User>> userObjectFactory;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(LazyAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(configApplicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";

        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        configApplicationContext.refresh();

        LazyAnnotationDependencyInjectionDemo demo = configApplicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);
        System.out.println("demo.user" + demo.user);
        System.out.println("demo.userObjectProvider" + demo.userObjectProvider.getObject());
        System.out.println("demo.userObjectFactory" + demo.userObjectFactory.getObject());

        demo.userObjectProvider.forEach(System.out::println);

        configApplicationContext.close();
    }

}
