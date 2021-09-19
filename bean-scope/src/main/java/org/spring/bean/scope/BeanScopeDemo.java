package org.spring.bean.scope;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @ClassName DependencySourceDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-16 19:08
 * @Version 1.0
 */
public class BeanScopeDemo {

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> users;

    @Bean
    public static User singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        return createUser();
    }

    private static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());

        return user;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(BeanScopeDemo.class);

        configApplicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                @Override
                public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean 名称： %s 在初始化之后回调...%n", bean.getClass().getName(), beanName);
                    return bean;
                }
            });
        });

        configApplicationContext.refresh();

        scopedBeansByLoopup(configApplicationContext);
        scopedBeansByInjection(configApplicationContext);



        configApplicationContext.close();
    }

    private static void scopedBeansByInjection(AnnotationConfigApplicationContext configApplicationContext) {
        BeanScopeDemo demo = configApplicationContext.getBean(BeanScopeDemo.class);
        System.out.println("beanScopeDemo.singletonUser " + demo.singletonUser);
        System.out.println("beanScopeDemo.singletonUser1 " + demo.singletonUser1);

        System.out.println("beanScopeDemo.prototypeUser " + demo.prototypeUser);
        System.out.println("beanScopeDemo.prototypeUser1 " + demo.prototypeUser1);
        System.out.println("beanScopeDemo.prototypeUser2 " + demo.prototypeUser2);

        System.out.println("beanScopeDemo.users " + demo.users);

    }

    private static void scopedBeansByLoopup(AnnotationConfigApplicationContext configApplicationContext) {
        for (int i = 0; i < 3; i++) {
            User user = configApplicationContext.getBean("singletonUser", User.class);
            System.out.println("单例User：" + user);

            User prototypeUser = configApplicationContext.getBean("prototypeUser", User.class);
            System.out.println("prototypeUser：" + prototypeUser);
        }
    }
}
