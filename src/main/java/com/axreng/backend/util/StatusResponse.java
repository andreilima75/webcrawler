package com.axreng.backend.util;

public enum StatusResponse {
    SUCCESS,
    ERROR;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
