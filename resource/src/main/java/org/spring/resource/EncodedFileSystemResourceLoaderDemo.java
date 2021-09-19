package org.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName EncodedFileSystemResourceDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-19 14:06
 * @Version 1.0
 */
public class EncodedFileSystemResourceLoaderDemo {

    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = "/" + System.getProperty("user.dir") + "/resource/src/main/java/org/spring/resource/EncodedFileSystemResourceDemo.java";
        System.out.println(currentJavaFilePath);

        FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource(currentJavaFilePath);

        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        try (Reader reader = encodedResource.getReader();) {
            System.out.println(IOUtils.toString(reader));
        }

    }
}
