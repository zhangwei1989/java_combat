package org.spring.ioc.overview.dependency.domain;

import javafx.beans.property.Property;
import org.spring.ioc.overview.annotation.Super;
import org.spring.ioc.overview.enums.City;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-08 23:15
 * @Version 1.0
 */
@Super
public class User implements BeanNameAware {

    private Long id;

    private String name;

    private City city;

    private Company company;

    private Properties properties;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", company=" + company +
                ", properties=" + properties +
                ", beanName='" + beanName + '\'' +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    private transient String beanName;

    public City[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(City[] workCities) {
        this.workCities = workCities;
    }

    private City[] workCities;

    @PostConstruct
    public void init() {
        System.out.println("用户 Bean [" + beanName + "]对象初始化。。。");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("用户 [" + beanName + "]对象销毁。。。");
    }

    public List<City> getLifeCities() {
        return lifeCities;
    }

    public void setLifeCities(List<City> lifeCities) {
        this.lifeCities = lifeCities;
    }

    private List<City> lifeCities;

    private Resource configFileLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public void setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("zhangwei");

        return user;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
