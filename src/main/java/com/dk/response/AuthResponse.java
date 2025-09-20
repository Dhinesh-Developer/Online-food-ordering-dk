package com.dk.response;

import com.dk.model.USER_ROLE;
import lombok.Data;

public class AuthResponse {

    private String jwt;
    private String message;
    private USER_ROLE role;

//    public AuthResponse(String jwt, String message, USER_ROLE role) {
//        this.jwt = jwt;
//        this.message = message;
//        this.role = role;
//    }

    public AuthResponse(String message, USER_ROLE role) {
        this.message = message;
        this.role = role;
    }

    public AuthResponse() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "jwt='" + jwt + '\'' +
                ", message='" + message + '\'' +
                ", role=" + role +
                '}';
    }
}
