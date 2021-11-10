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
    private String username;
    @NotBlank
    private String password;
    private String storedSalt;


    @ElementCollection(targetClass = String.class)
    private List<String> registeredGardens;
    @Column(nullable = true)
    private String defaultGarden;


    public User(String username, String password, String storedSalt, List<String> registeredGardens, String defaultGarden) {
        this.username = username;
        this.password = password;
        this.storedSalt = storedSalt;
        if(registeredGardens == null){
            this.registeredGardens = new ArrayList<String>();
        }else{
            this.registeredGardens = registeredGardens;
        }
        this.defaultGarden = defaultGarden;

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

    public String getDefaultGarden() {
        return defaultGarden;
    }

    public void setDefaultGarden(String defaultGarden) {
        this.defaultGarden = defaultGarden;
    }
}
