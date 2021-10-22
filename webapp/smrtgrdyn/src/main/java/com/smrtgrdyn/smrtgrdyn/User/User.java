package com.smrtgrdyn.smrtgrdyn.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_information")
public class User {

    @Id
    @NotBlank
    String username;
    @NotBlank
    String password;
    String storedSalt;

    @ElementCollection(targetClass = UUID.class)
    List<UUID> registeredGardens;



    public User(String username, String password, String storedSalt, List<UUID> registeredGardens) {
        this.username = username;
        this.password = password;
        this.storedSalt = storedSalt;
        this.registeredGardens = registeredGardens;
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

    public void setRegisteredGardens(List<UUID> registeredGardens) {
        this.registeredGardens = registeredGardens;
    }

    public List<UUID> getRegisteredGardens(){
        return this.registeredGardens;
    }

}
