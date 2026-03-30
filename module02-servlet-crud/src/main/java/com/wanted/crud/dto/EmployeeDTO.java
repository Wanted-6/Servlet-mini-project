package com.wanted.crud.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeDTO {
    private Long EMP_ID;
    private String EMP_NAME;
    private String EMP_DOB;
    private String EMAIL;
    private String PHONE;
    private String DEPT_CODE;
    private String JOB_CODE;
    private String SALE_LEVEL;
    private Long SALARY;
    private Double BONUS;
    private Long  MANAGER_ID;
    private LocalDateTime HIRE_DATE;
    private LocalDate ENT_DATE;
    private Boolean ENT_YN;

    public EmployeeDTO(Long EMP_ID, String EMP_NAME, String EMP_DOB, String EMAIL, String PHONE, String DEPT_CODE, String JOB_CODE, String SALE_LEVEL, Long SALARY, Double BONUS, Long MANAGER_ID, LocalDateTime HIRE_DATE, LocalDate ENT_DATE, Boolean ENT_YN) {
        this.EMP_ID = EMP_ID;
        this.EMP_NAME = EMP_NAME;
        this.EMP_DOB = EMP_DOB;
        this.EMAIL = EMAIL;
        this.PHONE = PHONE;
        this.DEPT_CODE = DEPT_CODE;
        this.JOB_CODE = JOB_CODE;
        this.SALE_LEVEL = SALE_LEVEL;
        this.SALARY = SALARY;
        this.BONUS = BONUS;
        this.MANAGER_ID = MANAGER_ID;
        this.HIRE_DATE = HIRE_DATE;
        this.ENT_DATE = ENT_DATE;
        this.ENT_YN = ENT_YN;
    }

    public Long getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(Long EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public String getEMP_NAME() {
        return EMP_NAME;
    }

    public void setEMP_NAME(String EMP_NAME) {
        this.EMP_NAME = EMP_NAME;
    }

    public String getEMP_DOB() {
        return EMP_DOB;
    }

    public void setEMP_DOB(String EMP_DOB) {
        this.EMP_DOB = EMP_DOB;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getDEPT_CODE() {
        return DEPT_CODE;
    }

    public void setDEPT_CODE(String DEPT_CODE) {
        this.DEPT_CODE = DEPT_CODE;
    }

    public String getJOB_CODE() {
        return JOB_CODE;
    }

    public void setJOB_CODE(String JOB_CODE) {
        this.JOB_CODE = JOB_CODE;
    }

    public String getSALE_LEVEL() {
        return SALE_LEVEL;
    }

    public void setSALE_LEVEL(String SALE_LEVEL) {
        this.SALE_LEVEL = SALE_LEVEL;
    }

    public Long getSALARY() {
        return SALARY;
    }

    public void setSALARY(Long SALARY) {
        this.SALARY = SALARY;
    }

    public Double getBONUS() {
        return BONUS;
    }

    public void setBONUS(Double BONUS) {
        this.BONUS = BONUS;
    }

    public Long getMANAGER_ID() {
        return MANAGER_ID;
    }

    public void setMANAGER_ID(Long MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public LocalDateTime getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(LocalDateTime HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public LocalDate getENT_DATE() {
        return ENT_DATE;
    }

    public void setENT_DATE(LocalDate ENT_DATE) {
        this.ENT_DATE = ENT_DATE;
    }

    public Boolean getENT_YN() {
        return ENT_YN;
    }

    public void setENT_YN(Boolean ENT_YN) {
        this.ENT_YN = ENT_YN;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "EMP_ID=" + EMP_ID +
                ", EMP_NAME='" + EMP_NAME + '\'' +
                ", EMP_DOB='" + EMP_DOB + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", PHONE='" + PHONE + '\'' +
                ", DEPT_CODE='" + DEPT_CODE + '\'' +
                ", JOB_CODE='" + JOB_CODE + '\'' +
                ", SALE_LEVEL='" + SALE_LEVEL + '\'' +
                ", SALARY=" + SALARY +
                ", BONUS=" + BONUS +
                ", MANAGER_ID=" + MANAGER_ID +
                ", HIRE_DATE=" + HIRE_DATE +
                ", ENT_DATE=" + ENT_DATE +
                ", ENT_YN=" + ENT_YN +
                '}';
    }

    public EmployeeDTO() {
    }
}
