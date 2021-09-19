package org.spring.bean.definition;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @ClassName BeanDefinitionCreationDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 11:31
 * @Version 1.0
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        beanDefinitionBuilder.addPropertyValue("id", 1L);
        beanDefinitionBuilder.addPropertyValue("name", "小张");

        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 1L).add("name", "小张");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
