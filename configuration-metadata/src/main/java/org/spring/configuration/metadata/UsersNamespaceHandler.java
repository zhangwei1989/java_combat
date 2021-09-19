package org.spring.configuration.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @ClassName UsersNamespaceHandler
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-18 22:40
 * @Version 1.0
 */
public class UsersNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
