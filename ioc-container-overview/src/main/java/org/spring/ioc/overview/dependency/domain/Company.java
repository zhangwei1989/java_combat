package org.spring.ioc.overview.dependency.domain;

/**
 * @ClassName Company
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-20 14:28
 * @Version 1.0
 */
public class Company {

    private String name;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
