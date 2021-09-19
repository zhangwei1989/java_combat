package org.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName XmlDependencySetterInjectionDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 23:39
 * @Version 1.0
 */
public class ApiDependencySetterInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(ApiDependencySetterInjectionDemo.class);

        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        configApplicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(configApplicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";

        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        configApplicationContext.refresh();

        UserHolder userHolder = configApplicationContext.getBean(UserHolder.class);

        System.out.println(userHolder);

        configApplicationContext.close();
    }

    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addPropertyReference("user", "superUser");
        return beanDefinitionBuilder.getBeanDefinition();
    }
}
