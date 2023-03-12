package com.prayesh.mts.RequestHandlers;


public class LoginUser {
    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginUser() {
    }

}
