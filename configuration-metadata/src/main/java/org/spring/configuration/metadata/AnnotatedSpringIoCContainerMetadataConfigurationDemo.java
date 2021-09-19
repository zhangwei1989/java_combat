package org.spring.configuration.metadata;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @ClassName AnnotatedSpringIoCContainerMetadataConfigurationDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-18 22:14
 * @Version 1.0
 */
@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
//@Import(User.class)
@PropertySource("classpath:/META-INF/users-beans-config.properties")
@PropertySource("classpath:/META-INF/users-beans-config.properties")
public class AnnotatedSpringIoCContainerMetadataConfigurationDemo {

    @Bean
    public User configuredUser(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotatedSpringIoCContainerMetadataConfigurationDemo.class);

        context.refresh();

        Map<String, User> usersMap = context.getBeansOfType(User.class);

        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            System.out.printf("User Bean Name : %s, content : %s \n", entry.getKey(), entry.getValue());
        }

        context.close();
    }
}
