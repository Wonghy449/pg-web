package com.pixel.pgback.entity.EM;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.entity
 * @Author: zhouzw
 * @CreateTime: 2019/6/30 2:30
 * @Description: interviewer excel model
 */
public class InterviewerEM extends BaseRowModel {
    private Integer id;

    @ExcelProperty(index = 0)
    private String email;

    @ExcelProperty(index = 1)
    private String lastName;

    @ExcelProperty(index = 2)
    private String firstName;

    @ExcelProperty(index = 3)
    private String level;

    @ExcelProperty(index = 4)
    private String function;

    @ExcelProperty(index = 5)
    private String location;

    private String supportCity;

    private String interviewType;

    private String interviewArea;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSupportCity() {
        return supportCity;
    }

    public void setSupportCity(String supportCity) {
        this.supportCity = supportCity;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getInterviewArea() {
        return interviewArea;
    }

    public void setInterviewArea(String interviewArea) {
        this.interviewArea = interviewArea;
    }

    @Override
    public String toString() {
        return "Interviewer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", level='" + level + '\'' +
                ", function='" + function + '\'' +
                ", location='" + location + '\'' +
                ", supportCity='" + supportCity + '\'' +
                ", interviewType='" + interviewType + '\'' +
                ", interviewArea='" + interviewArea + '\'' +
                '}';
    }
}
