package org.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

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
public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = System.getProperty("user.dir") + "/resource/src/main/java/org/spring/resource/EncodedFileSystemResourceDemo.java";
        System.out.println(currentJavaFilePath);
        File currentJavaFile = new File(currentJavaFilePath);

        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFilePath);

        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");

        try (Reader reader = encodedResource.getReader();) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
