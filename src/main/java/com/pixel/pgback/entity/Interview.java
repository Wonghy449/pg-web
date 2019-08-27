package com.pixel.pgback.entity;

import java.util.Date;

public class Interview {
    private Integer id;

    private Integer intervieweeId;

    private Integer interviewerId;

    private Date time;

    private String location;

    private String interviewType;

    private String interviewResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIntervieweeId() {
        return intervieweeId;
    }

    public void setIntervieweeId(Integer intervieweeId) {
        this.intervieweeId = intervieweeId;
    }

    public Integer getInterviewerId() {
        return interviewerId;
    }

    public void setInterviewerId(Integer interviewerId) {
        this.interviewerId = interviewerId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType == null ? null : interviewType.trim();
    }

    public String getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(String interviewResult) {
        this.interviewResult = interviewResult == null ? null : interviewResult.trim();
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", intervieweeId=" + intervieweeId +
                ", interviewerId=" + interviewerId +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", interviewType='" + interviewType + '\'' +
                ", interviewResult='" + interviewResult + '\'' +
                '}';
    }
}