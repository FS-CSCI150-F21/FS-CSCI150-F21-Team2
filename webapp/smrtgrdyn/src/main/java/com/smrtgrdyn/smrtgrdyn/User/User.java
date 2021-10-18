package com.smrtgrdyn.smrtgrdyn.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
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
