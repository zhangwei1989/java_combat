package org.spring.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @ClassName ExternalConfigurationDependencySourceDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-16 22:31
 * @Version 1.0
 */
@Configuration
@PropertySource("META-INF/default.properties")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id:-1}")
    private Long id;

    @Value("${user.resource:classpath://default.properties}")
    private Resource resource;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(ExternalConfigurationDependencySourceDemo.class);

        configApplicationContext.refresh();

        ExternalConfigurationDependencySourceDemo demo = configApplicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);

        System.out.println(demo.id);
        System.out.println(demo.resource);

        configApplicationContext.close();
    }
}
