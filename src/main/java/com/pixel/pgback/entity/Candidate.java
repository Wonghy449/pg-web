package com.pixel.pgback.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class Candidate extends BaseRowModel {
    private Integer id;

    @ExcelProperty(index = 0)
    private String positionId;

    @ExcelProperty(index = 1)
    private Date applicationDate;

    @ExcelProperty(index = 2)
    private String name;

    @ExcelProperty(index = 4)
    private String firstChoice;

    @ExcelProperty(index = 5)
    private String secondChoice;

    @ExcelProperty(index = 8)
    private String function;

    @ExcelProperty(index = 28)
    private String email;

    @ExcelProperty(index = 34)
    private String phoneNo;

    @ExcelProperty(index = 36)
    private String institution;

    @ExcelProperty(index = 37)
    private String degree;

    @ExcelProperty(index = 38)
    private String major;

    @ExcelProperty(index = 39, format = "yyyy/MM/dd")
    private Date graduationTime;

    @ExcelProperty(index = 40)
    private String expectedInterviewCity;

    @ExcelProperty(index = 41)
    private String gender;

    @ExcelProperty(index = 44)
    private Date earlyJoinDate;

    @ExcelProperty(index = 46)
    private String expectedWorkCity;

    private String cv;

    private String status;

    private String interviewArea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Date getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Date graduationTime) {
        this.graduationTime = graduationTime;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getExpectedWorkCity() {
        return expectedWorkCity;
    }

    public void setExpectedWorkCity(String expectedWorkCity) {
        this.expectedWorkCity = expectedWorkCity == null ? null : expectedWorkCity.trim();
    }

    public String getFirstChoice() {
        return firstChoice;
    }

    public void setFirstChoice(String firstChoice) {
        this.firstChoice = firstChoice == null ? null : firstChoice.trim();
    }

    public String getSecondChoice() {
        return secondChoice;
    }

    public void setSecondChoice(String secondChoice) {
        this.secondChoice = secondChoice == null ? null : secondChoice.trim();
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv == null ? null : cv.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getInterviewArea() {
        return interviewArea;
    }

    public void setInterviewArea(String interviewArea) {
        this.interviewArea = interviewArea == null ? null : interviewArea.trim();
    }

    public String getExpectedInterviewCity() {
        return expectedInterviewCity;
    }

    public void setExpectedInterviewCity(String expectedInterviewCity) {
        this.expectedInterviewCity = expectedInterviewCity == null ? null : expectedInterviewCity.trim();
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public Date getEarlyJoinDate() {
        return earlyJoinDate;
    }

    public void setEarlyJoinDate(Date earlyJoinDate) {
        this.earlyJoinDate = earlyJoinDate;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", institution='" + institution + '\'' +
                ", degree='" + degree + '\'' +
                ", major='" + major + '\'' +
                ", graduationTime=" + graduationTime +
                ", applicationDate=" + applicationDate +
                ", expectedWorkCity='" + expectedWorkCity + '\'' +
                ", firstChoice='" + firstChoice + '\'' +
                ", secondChoice='" + secondChoice + '\'' +
                ", cv='" + cv + '\'' +
                ", status='" + status + '\'' +
                ", interviewArea='" + interviewArea + '\'' +
                ", expectedInterviewCity='" + expectedInterviewCity + '\'' +
                ", positionId='" + positionId + '\'' +
                ", function='" + function + '\'' +
                ", earlyJoinDate=" + earlyJoinDate +
                '}';
    }
}