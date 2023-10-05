package com.project.Restaurant_Managementv2.dto.user;

public class SignInResponseDto {
    private String status;
    private String token;

    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SignInResponseDto(String status, String token, Object data) {
        this.status = status;
        this.token = token;
        this.data=data;
    }
}
