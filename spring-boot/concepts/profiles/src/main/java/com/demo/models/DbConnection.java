package com.demo.models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbConnection {
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @PostConstruct
    public void init(){
        System.out.println(username+" : "+password);
    }
    public DbConnection() {
    }

    public DbConnection(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
