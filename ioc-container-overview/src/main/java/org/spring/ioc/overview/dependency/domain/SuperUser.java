package org.spring.ioc.overview.dependency.domain;

/**
 * @ClassName SuperUser
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-08 23:38
 * @Version 1.0
 */
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
