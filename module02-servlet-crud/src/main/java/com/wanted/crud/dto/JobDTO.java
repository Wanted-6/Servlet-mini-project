package com.wanted.crud.dto;

public class JobDTO {
    private String JOB_CODE;
    private String JOB_NAME;

    public JobDTO() {}

    public JobDTO(String JOB_CODE, String JOB_NAME) {
        this.JOB_CODE = JOB_CODE;
        this.JOB_NAME = JOB_NAME;
    }

    public String getJOB_CODE() {
        return JOB_CODE;
    }

    public void setJOB_CODE(String JOB_CODE) {
        this.JOB_CODE = JOB_CODE;
    }

    public String getJOB_NAME() {
        return JOB_NAME;
    }

    public void setJOB_NAME(String JOB_NAME) {
        this.JOB_NAME = JOB_NAME;
    }

    @Override
    public String toString() {
        return "JobDTO{" +
                "JOB_CODE='" + JOB_CODE + '\'' +
                ", JOB_NAME='" + JOB_NAME + '\'' +
                '}';
    }
}
