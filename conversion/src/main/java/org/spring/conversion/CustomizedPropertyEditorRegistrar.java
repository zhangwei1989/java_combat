package org.spring.conversion;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomizedPropertyEditorRegistrar
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-20 16:06
 * @Version 1.0
 */
@Component
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(User.class, "properties", new StringToPropertiesPropertyEditor());
    }
}
