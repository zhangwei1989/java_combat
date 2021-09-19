package org.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.stream.Stream;

/**
 * @ClassName CustomizedResourcePatternResolverDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-19 14:59
 * @Version 1.0
 */
public class CustomizedResourcePatternResolverDemo {

    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = "/" + System.getProperty("user.dir") + "/resource/src/main/java/org/spring/resource/";
        String locationPattern = currentJavaFilePath + "*.java";

        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver((new FileSystemResourceLoader()));

        Resource[] resources = resourcePatternResolver.getResources(locationPattern);

        Stream.of(resources).map(CustomizedResourcePatternResolverDemo::getContent).forEach(System.out::println);
    }

    public static String getContent(Resource resource) {
        try {
            return getContent(resource, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String getContent(Resource resource, String encoding) throws IOException {
        EncodedResource encodedResource = new EncodedResource(resource, encoding);

        try (Reader reader = encodedResource.getReader()) {
            return IOUtils.toString(reader);
        }
    }
}
