package org.spring.dependency.injection;

import org.spring.dependency.injection.annotation.UserGroup;
import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @ClassName XmlDependencySetterInjectionDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 23:39
 * @Version 1.0
 */
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("user")
    private User nameUser;

    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    @Autowired
    @UserGroup
    private Collection<User> groupUsers;



    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(configApplicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";

        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        configApplicationContext.refresh();

        QualifierAnnotationDependencyInjectionDemo demo = configApplicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);
        System.out.println("demo.user" + demo.user);
        System.out.println("demo.nameUser" + demo.nameUser);
        System.out.println("demo.allUsers" + demo.allUsers);
        System.out.println("demo.allUsers count" + demo.allUsers.size());
        System.out.println("demo.qualifiedUsers" + demo.qualifiedUsers);
        System.out.println("demo.qualifiedUsers count" + demo.qualifiedUsers.size());
        System.out.println("demo.groupUsers" + demo.groupUsers);

        configApplicationContext.close();
    }

    @Bean
    @Qualifier
    public User user1() {
        User user = new User();
        user.setId(7L);

        return user;
    }

    @Bean
    @Qualifier
    public User user2() {
        User user = new User();
        user.setId(8L);

        return user;
    }

    @Bean
    @UserGroup
    public User user3() {
        User user = new User();
        user.setId(9L);

        return user;
    }
}
