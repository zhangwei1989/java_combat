package org.spring.configuration.metadata;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * @ClassName PropertySourceDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-18 23:22
 * @Version 1.0
 */
@PropertySource("classpath:/META-INF/users-beans-config.properties")
public class PropertySourceDemo {

    @Bean
    public User user(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertySourceDemo.class);

        context.refresh();

        Map<String, User> usersMap = context.getBeansOfType(User.class);

        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            System.out.printf("User Bean Name : %s, content : %s \n", entry.getKey(), entry.getValue());
        }

        System.out.println(context.getEnvironment().getPropertySources());

        context.close();
    }
}
