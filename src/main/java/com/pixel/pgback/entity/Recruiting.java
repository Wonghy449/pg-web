package com.pixel.pgback.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.entity
 * @Author: zhouzw
 * @CreateTime: 2019/6/22 19:31
 * @Description: 招聘团队
 */
public class Recruiting extends BaseRowModel {
    private Integer id;

    @ExcelProperty(index = 0)
    private String email;

    @ExcelProperty(index = 1)
    private String firstName;

    @ExcelProperty(index = 2)
    private String lastName;

    @ExcelProperty(index = 3)
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Recruiting{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
