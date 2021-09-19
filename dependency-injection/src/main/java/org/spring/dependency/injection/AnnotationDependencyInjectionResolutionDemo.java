package org.spring.dependency.injection;

import org.spring.dependency.injection.annotation.InjectedUser;
import org.spring.dependency.injection.annotation.MyAutowired;
import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * @ClassName XmlDependencySetterInjectionDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 23:39
 * @Version 1.0
 */
public class AnnotationDependencyInjectionResolutionDemo {

    @MyAutowired
    private User user;

    @InjectedUser
    private User injectedUser;

    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet<>(Arrays.asList(Autowired.class, InjectedUser.class, MyAutowired.class));
        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);

        return beanPostProcessor;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(configApplicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";

        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        configApplicationContext.refresh();

        AnnotationDependencyInjectionResolutionDemo demo = configApplicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);
        System.out.println("demo.user" + demo.user);
        System.out.println("demo.injectedUser" + demo.injectedUser);

        configApplicationContext.close();
    }

}
