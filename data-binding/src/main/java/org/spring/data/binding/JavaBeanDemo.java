package org.spring.data.binding;

import org.spring.ioc.overview.dependency.domain.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @ClassName JavaBeanDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-20 14:54
 * @Version 1.0
 */
public class JavaBeanDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
                });

        System.out.println("============================");

        Stream.of(beanInfo.getMethodDescriptors())
                .forEach(methodDescriptor -> {
                    System.out.println(methodDescriptor);
                });
    }
}
