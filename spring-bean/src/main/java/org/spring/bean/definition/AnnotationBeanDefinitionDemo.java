package org.spring.bean.definition;

import org.spring.ioc.overview.container.AnnotationApplicationContextAsIocContainerDemo;
import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @ClassName AnnotationBeanDefinitionDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 13:20
 * @Version 1.0
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(AnnotationBeanDefinitionDemo.class);
        configApplicationContext.refresh();

        registerUserBeanDefinition(configApplicationContext, "zhangwei-user");
        registerUserBeanDefinition(configApplicationContext);

        System.out.println("Config 类型的所有 Beans" + configApplicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans" + configApplicationContext.getBeansOfType(User.class));

        configApplicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1L).addPropertyValue("name", "zhangwei");

        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        }else{
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    @Component
    public static class Config {

        @Bean(name = {"user", "xiaozhang"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("zhangwei");

            return user;
        }
    }

}
