package com.axreng.backend.util;


import com.google.gson.JsonElement;

public class StandardResponse {
    private StatusResponse status;
    private String id;
    private JsonElement data;

    public StandardResponse(StatusResponse status) {
        this.status = status;
    }

    public StandardResponse(StatusResponse status, String id) {
        this.id = id;
    }

    public StandardResponse(StatusResponse status, JsonElement data) {
        this.data = data;
    }

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
}

