package com.pixel.pgback.entity;

import java.util.Date;

public class CandidateSelectedTime{
    private Integer id;

    private Integer candidateId;

    private Date selectedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Date getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(Date selectedTime) {
        this.selectedTime = selectedTime;
    }

    @Override
    public String toString() {
        return "CandidateSelectedTime{" +
                "id=" + id +
                ", candidateId=" + candidateId +
                ", selectedTime='" + selectedTime + '\'' +
                '}';
    }
}