package org.spring.configuration.metadata;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName BeanConfigurationMetadataDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-18 18:37
 * @Version 1.0
 */
public class BeanConfigurationMetadataDemo {

    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "lily");

        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.setAttribute("name", "lilei");
        beanDefinition.setSource(BeanConfigurationMetadataDemo.class);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                    if (BeanConfigurationMetadataDemo.class.equals(bd.getSource())) {
                        System.out.println(bd.getSource());
                        String name = (String) bd.getAttribute("name");
                        System.out.println(name);
                        User user = (User) bean;
                        user.setName(name);
                    }

                }

                return bean;
            }
        });

        beanFactory.registerBeanDefinition("user", beanDefinition);



        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

    }
}
