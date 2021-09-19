package org.spring.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @ClassName ResolvableDependencySourceDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-16 22:09
 * @Version 1.0
 */
public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(ResolvableDependencySourceDemo.class);

        configApplicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerResolvableDependency(String.class, "Hello World!");
        });

        configApplicationContext.refresh();

        ResolvableDependencySourceDemo demo = configApplicationContext.getBean(ResolvableDependencySourceDemo.class);

        configApplicationContext.close();
    }
}
