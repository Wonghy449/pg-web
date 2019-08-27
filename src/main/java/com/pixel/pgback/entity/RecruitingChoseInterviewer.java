package com.pixel.pgback.entity;

public class RecruitingChoseInterviewer {
    private Integer id;

    private Integer interviewerId;

    private String interviewArea;

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

    @Override
    public String toString() {
        return "RecruitingChoseInterviewer{" +
                "id=" + id +
                ", interviewerId=" + interviewerId +
                ", interviewArea='" + interviewArea + '\'' +
                '}';
    }
}