package com.smrtgrdyn.smrtgrdyn.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user_information")
public class User {

    @Id
    @NotBlank
    String username;
    @NotBlank
    String password;
    String storedSalt;

    @ElementCollection(targetClass = String.class)
    List<String> registeredGardens;



    public User(String username, String password, String storedSalt, List<String> registeredGardens) {
        this.username = username;
        this.password = password;
        this.storedSalt = storedSalt;
        if(registeredGardens == null){
            this.registeredGardens = new ArrayList<String>();
        }else{
            this.registeredGardens = registeredGardens;
        }

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

    public void setRegisteredGardens(List<String> registeredGardens) {
        if(registeredGardens == null){
            this.registeredGardens = new ArrayList<String>();
        }else{
            this.registeredGardens = registeredGardens;
        }
    }

    public List<String> getRegisteredGardens(){
        if(this.registeredGardens == null){
            this.registeredGardens = new ArrayList<String>();
        }
        return this.registeredGardens;
    }

}
