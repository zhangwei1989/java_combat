package org.spring.generic;

        import org.springframework.core.GenericTypeResolver;

        import java.lang.reflect.Method;
        import java.util.List;

/**
 * @ClassName GenericTypeResolverDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-21 10:49
 * @Version 1.0
 */
public class GenericTypeResolverDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method =  GenericTypeResolverDemo.class.getMethod("getString");
        Method method1 =  GenericTypeResolverDemo.class.getMethod("getList");

        Class<?> returnType = GenericTypeResolver.resolveReturnType(method, GenericTypeResolverDemo.class);
        Class<?> returnType1 = GenericTypeResolver.resolveReturnType(method1, GenericTypeResolverDemo.class);

        System.out.println(String.class.equals(returnType));
        System.out.println(String.class.equals(returnType1));
        System.out.println(GenericTypeResolver.resolveReturnTypeArgument(method, GenericTypeResolverDemo.class));
        System.out.println(GenericTypeResolver.resolveReturnTypeArgument(method1, GenericTypeResolverDemo.class));
    }

    public static String getString() {
        return null;
    }

    public static <E> List<E> getList() {
        return null;
    }
}
