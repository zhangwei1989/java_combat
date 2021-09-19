package org.spring.bean.definition;

import org.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName BeanGabageCollectionDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-10 15:37
 * @Version 1.0
 */
public class BeanGabageCollectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(BeanInitializationDemo.class);
        configApplicationContext.refresh();

        System.out.println("Spring 初始化完成。。。");


        System.out.println("Spring 准备关闭。。。");
        configApplicationContext.close();
        System.out.println("Spring 销毁已关闭。。。");

        System.gc();
    }
}
