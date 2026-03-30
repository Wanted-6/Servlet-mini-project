package com.wanted.crud.dto;

public class DepartmentDTO {
    private Long DEPT_ID;
    private String DEPT_TITLE;
    private String LOCATION_ID;

    public DepartmentDTO(Long DEPT_ID, String DEPT_TITLE, String LOCATION_ID) {
        this.DEPT_ID = DEPT_ID;
        this.DEPT_TITLE = DEPT_TITLE;
        this.LOCATION_ID = LOCATION_ID;
    }

    public Long getDEPT_ID() {
        return DEPT_ID;
    }

    public void setDEPT_ID(Long DEPT_ID) {
        this.DEPT_ID = DEPT_ID;
    }

    public String getDEPT_TITLE() {
        return DEPT_TITLE;
    }

    public void setDEPT_TITLE(String DEPT_TITLE) {
        this.DEPT_TITLE = DEPT_TITLE;
    }

    public String getLOCATION_ID() {
        return LOCATION_ID;
    }

    public void setLOCATION_ID(String LOCATION_ID) {
        this.LOCATION_ID = LOCATION_ID;
    }

    public DepartmentDTO() {
    }

    @Override
    public String toString() {
        return "DepartmentdDTO{" +
                "DEPT_ID=" + DEPT_ID +
                ", DEPT_TITLE='" + DEPT_TITLE + '\'' +
                ", LOCATION_ID='" + LOCATION_ID + '\'' +
                '}';
    }
}
