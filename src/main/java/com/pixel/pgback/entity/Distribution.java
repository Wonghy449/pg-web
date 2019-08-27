package com.pixel.pgback.entity;

public class Distribution {
    private Integer id;

    private Integer candidateId;

    private String recommendation;

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

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation == null ? null : recommendation.trim();
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "id=" + id +
                ", candidateId=" + candidateId +
                ", recommendation='" + recommendation + '\'' +
                '}';
    }
}