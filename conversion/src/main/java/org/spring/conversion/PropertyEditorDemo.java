package org.spring.conversion;

import java.beans.PropertyEditor;

/**
 * @ClassName PropertyEditorDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-20 15:35
 * @Version 1.0
 */
public class PropertyEditorDemo {

    public static void main(String[] args) {
        String text = "name = lily";

        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();
        propertyEditor.setAsText(text);

        System.out.println(propertyEditor.getValue() );
    }
}
