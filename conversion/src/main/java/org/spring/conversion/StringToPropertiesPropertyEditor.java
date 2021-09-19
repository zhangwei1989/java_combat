package org.spring.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @ClassName StringToPropertiesPropertyEditor
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-20 15:35
 * @Version 1.0
 */
public class StringToPropertiesPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    @Override
    public void setAsText(String text) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setValue(properties);
    }
}
