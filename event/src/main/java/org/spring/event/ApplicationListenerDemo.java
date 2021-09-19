package org.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName ApplicationListenerDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-21 14:28
 * @Version 1.0
 */
@EnableAsync
public class ApplicationListenerDemo implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public static void main(String[] args) {
//        GenericApplicationContext applicationContext = new GenericApplicationContext();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationListenerDemo.class);


        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("接收到 Spring 事件：" + event);
            }
        });

        applicationContext.refresh();
        applicationContext.close();
    }

    @EventListener
    @Async
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("@EventListener - 接收到 Spring 事件：" + event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new ApplicationEvent("Hello World!") {

        });

        applicationEventPublisher.publishEvent("Hello World~");
    }
}
