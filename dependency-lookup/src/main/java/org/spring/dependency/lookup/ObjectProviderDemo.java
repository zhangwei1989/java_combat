package org.spring.dependency.lookup;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName ObjectProviderDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 16:33
 * @Version 1.0
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(ObjectProviderDemo.class);
        configApplicationContext.refresh();

        lookupByObjectProvider(configApplicationContext);
        lookupIfAvailable(configApplicationContext);
        lookupByStreamOps(configApplicationContext);

        configApplicationContext.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext configApplicationContext) {
        ObjectProvider<String> objectProvider = configApplicationContext.getBeanProvider(String.class);
        Iterable<String> stringIterable = objectProvider;

        for (String string : stringIterable) {
            System.out.println(string);
        }

        objectProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext configApplicationContext) {
        ObjectProvider<User> objectProvider = configApplicationContext.getBeanProvider(User.class);
        User user = objectProvider.getIfAvailable(User::createUser);

        System.out.println(user);
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext configApplicationContext) {
        ObjectProvider<String> objectProvider = configApplicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

    @Bean
    @Primary
    public String helloWorld() {
        return "Hello World";
    }

    @Bean
    public String message() {
        return "Message";
    }

}
