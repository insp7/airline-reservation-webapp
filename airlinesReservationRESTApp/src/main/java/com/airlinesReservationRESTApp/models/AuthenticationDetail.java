package com.airlinesReservationRESTApp.models;

public class AuthenticationDetail {
    private String email;
    private String password;

    public AuthenticationDetail() { }

    public AuthenticationDetail(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "AuthenticationDetails{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
