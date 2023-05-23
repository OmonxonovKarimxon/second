package com.company.dto;

import javax.validation.constraints.NotNull;


public class AuthDTO {

    private String email;
    @NotNull(message = "password is null")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
