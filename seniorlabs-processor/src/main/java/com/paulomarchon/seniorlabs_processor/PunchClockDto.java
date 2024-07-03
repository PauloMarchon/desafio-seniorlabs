package com.paulomarchon.seniorlabs_processor;

public class PunchClockDto {
    String includedAt;
    Integer employeeId;
    Integer employerId;

    public PunchClockDto() {
    }

    public PunchClockDto(String includedAt, Integer employeeId, Integer employerId) {
        this.includedAt = includedAt;
        this.employeeId = employeeId;
        this.employerId = employerId;
    }

    public String getIncludedAt() {
        return includedAt;
    }

    public void setIncludedAt(String includedAt) {
        this.includedAt = includedAt;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }
}
