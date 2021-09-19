package org.spring.resource;

import org.apache.commons.io.IOUtils;
import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @ClassName CustomizedResourcePatternResolverDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-19 14:59
 * @Version 1.0
 */
public class InjectingResourceDemo {

    @Value("classpath:/META-INF/default.properties")
    private Resource resource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] resources;

    @PostConstruct
    public void init() {
        System.out.println(CustomizedResourcePatternResolverDemo.getContent(resource));
        System.out.println("=====================================");
        Stream.of(resources).map(CustomizedResourcePatternResolverDemo::getContent).forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingResourceDemo.class);

        context.refresh();

        context.close();
    }

}
