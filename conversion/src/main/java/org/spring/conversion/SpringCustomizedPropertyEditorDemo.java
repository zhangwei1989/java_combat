package org.spring.conversion;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyEditor;

/**
 * @ClassName PropertyEditorDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-20 15:35
 * @Version 1.0
 */
public class SpringCustomizedPropertyEditorDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/property-editors-context.xml");

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        applicationContext.close();
    }
}
