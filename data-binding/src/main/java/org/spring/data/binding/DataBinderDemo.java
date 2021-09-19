package org.spring.data.binding;

import org.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DataBinderDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-20 14:21
 * @Version 1.0
 */
public class DataBinderDemo {

    public static void main(String[] args) {
        User user = new User();

        DataBinder binder = new DataBinder(user, "user");
        Map<String, Object> source = new HashMap<>();
        source.put("id", 1);
        source.put("name", "lily");

        source.put("age", 18);

        source.put("company.name", "google");

        PropertyValues propertyValues = new MutablePropertyValues(source);

        // binder.setIgnoreUnknownFields(false);

        binder.setAutoGrowNestedPaths(false);
        binder.setIgnoreInvalidFields(true);

        binder.setRequiredFields("id", "city");

        binder.bind(propertyValues);

        System.out.println(user);

        BindingResult result = binder.getBindingResult();

        System.out.println(result);
    }
}
