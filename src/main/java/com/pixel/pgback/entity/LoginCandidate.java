package com.pixel.pgback.entity;

public class LoginCandidate {
    private Integer id;

    private Integer candidateId;

    private String username;

    private String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "LoginCandidate{" +
                "id=" + id +
                ", candidateId=" + candidateId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}