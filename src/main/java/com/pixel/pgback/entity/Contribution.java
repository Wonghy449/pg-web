package com.pixel.pgback.entity;

public class Contribution {
    private Integer id;

    private Integer interviewerId;

    private String interviewArea;

    private Integer contributionDays;

    private Integer intervieweeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInterviewerId() {
        return interviewerId;
    }

    public void setInterviewerId(Integer interviewerId) {
        this.interviewerId = interviewerId;
    }

    public String getInterviewArea() {
        return interviewArea;
    }

    public void setInterviewArea(String interviewArea) {
        this.interviewArea = interviewArea == null ? null : interviewArea.trim();
    }

    public Integer getContributionDays() {
        return contributionDays;
    }

    public void setContributionDays(Integer contributionDays) {
        this.contributionDays = contributionDays;
    }

    public Integer getIntervieweeId() {
        return intervieweeId;
    }

    public void setIntervieweeId(Integer intervieweeId) {
        this.intervieweeId = intervieweeId;
    }

    @Override
    public String toString() {
        return "Contribution{" +
                "id=" + id +
                ", interviewerId=" + interviewerId +
                ", interviewArea='" + interviewArea + '\'' +
                ", contributionDays=" + contributionDays +
                ", intervieweeId=" + intervieweeId +
                '}';
    }
}