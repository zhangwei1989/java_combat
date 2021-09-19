package org.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * @ClassName CustomizedResourcePatternResolverDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-19 14:59
 * @Version 1.0
 */
public class InjectingResourceLoaderDemo implements ResourceLoaderAware {

    private ResourceLoader awareResourceLoader;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init() {
        System.out.println("awareResourceLoader == resourceLoader :" + (awareResourceLoader == resourceLoader));
        System.out.println("=====================================");
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingResourceLoaderDemo.class);

        context.refresh();

        context.close();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.awareResourceLoader = resourceLoader;
    }
}
