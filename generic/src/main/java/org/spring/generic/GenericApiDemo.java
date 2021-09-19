package org.spring.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @ClassName GenericApiDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-21 10:37
 * @Version 1.0
 */
public class GenericApiDemo {

    public static void main(String[] args) {
        Class intClass = int.class;

        Class objectArrayClass = Object[].class;

        Class rawClass = String.class;

        Class genericClass = ArrayList.class;

        ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();

        System.out.println(genericClass);
        System.out.println(parameterizedType);

        Type[] typeVariables = parameterizedType.getActualTypeArguments();

        Stream.of(typeVariables).forEach(System.out::println);
    }
}
