package com.tfs.mkaratusi.mkaratusi.pojo;

/**
 * Created by Dell on 1/23/2018.
 */

public class User {
    public int id;
    public  int Station_id;
    public String name;
    public Boolean status;
    public String password;
    public String username;
    public String station;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStation_id() {
        return Station_id;
    }

    public void setStation_id(int station_id) {
        Station_id = station_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
