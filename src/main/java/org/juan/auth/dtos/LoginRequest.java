package org.juan.auth.dtos;


public class LoginRequest {
    public String user;

    public String password;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
