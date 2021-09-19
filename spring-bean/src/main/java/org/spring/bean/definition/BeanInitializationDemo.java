package org.spring.bean.definition;

import org.spring.bean.factory.DefaultUserFactory;
import org.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @ClassName BeanInitializationDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 15:04
 * @Version 1.0
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(BeanInitializationDemo.class);
        configApplicationContext.refresh();

        System.out.println("Spring 初始化完成。。。");
        UserFactory userFactory = configApplicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);

        System.out.println("Spring 准备关闭。。。");
        configApplicationContext.close();
        System.out.println("Spring 销毁已关闭。。。");
    }

    @Lazy(value = false)
    @Bean(initMethod = "initUserFactory", destroyMethod = "destroyUserFactory")
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
