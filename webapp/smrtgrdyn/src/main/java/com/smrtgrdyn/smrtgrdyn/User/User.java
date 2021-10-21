package com.smrtgrdyn.smrtgrdyn.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @NotBlank
    String username;
    @NotBlank
    String password;
    String storedSalt;



    public User(String username, String password, String storedSalt) {
        this.username = username;
        this.password = password;
        this.storedSalt = storedSalt;
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

    public String getStoredSalt() {
        return storedSalt;
    }

    public void setStoredSalt(String storedSalt) {
        this.storedSalt = storedSalt;
    }

}
