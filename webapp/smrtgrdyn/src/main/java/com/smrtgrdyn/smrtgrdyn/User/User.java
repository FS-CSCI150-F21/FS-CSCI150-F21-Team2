package com.smrtgrdyn.smrtgrdyn.User;

import com.smrtgrdyn.smrtgrdyn.Garden.GardenInformation;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    String username;
    //Permissions permission; super user? regular user? maybe later?
    List<UUID> gardens; //list of all the connected garden ids for this user

    public User(String username, List<UUID> gardens) {
        this.username = username;
        this.gardens = gardens;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UUID> getGardens() {
        return gardens;
    }

    public void setGardens(List<UUID> gardens) {
        this.gardens = gardens;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", gardens=" + gardens +
                '}';
    }
}
