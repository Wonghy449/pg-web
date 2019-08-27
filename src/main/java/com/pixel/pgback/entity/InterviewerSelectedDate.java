package com.pixel.pgback.entity;

import java.util.Date;

public class InterviewerSelectedDate {
    private Integer id;

    private Integer interviewerId;

    private Date selectedDate;

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

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    @Override
    public String toString() {
        return "InterviewerSelectedDate{" +
                "id=" + id +
                ", interviewerId=" + interviewerId +
                ", selectedDate=" + selectedDate +
                '}';
    }
}