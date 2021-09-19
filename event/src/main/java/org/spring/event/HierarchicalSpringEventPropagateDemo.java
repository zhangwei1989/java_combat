package org.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @ClassName HierarchicalSpringEventPropagateDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-24 18:47
 * @Version 1.0
 */
public class HierarchicalSpringEventPropagateDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.setId("parent-context");
        parentContext.register(MyListener.class);

        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
        currentContext.setId("current-context");
        currentContext.setParent(parentContext);
        currentContext.register(MyListener.class);

        parentContext.refresh();

        currentContext.refresh();

        parentContext.close();
        currentContext.close();
    }

    static class MyListener implements ApplicationListener<ContextRefreshedEvent> {

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.printf("监听到 Spring 应用上下文[ ID ：%s ] 的 ContextRefreshedEvent \n", event.getApplicationContext().getId());
        }
    }

}
