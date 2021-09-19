package org.spring.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * @ClassName DependencySourceDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-16 19:08
 * @Version 1.0
 */
public class DependencySourceDemo {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void init() {
        System.out.println("beanFactory == applicationContext " + (beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getBeanFactory() " + (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("resourceLoader == applicationContext " + (resourceLoader == applicationContext));
        System.out.println("applicationEventPublisher == applicationContext " + (applicationEventPublisher == applicationContext));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(DependencySourceDemo.class);

        configApplicationContext.refresh();

        DependencySourceDemo demo = configApplicationContext.getBean(DependencySourceDemo.class);

        configApplicationContext.close();
    }
}
