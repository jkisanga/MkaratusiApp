package com.tfs.mkaratusi.mkaratusi.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dell on 2/12/2018.
 */

public class RPosUser extends RealmObject {

    @PrimaryKey
    private Integer id;
    private Integer userId;
    private Integer checkpointId;
    private String checkpointName;
    private String officerName;
    private String pOSId;
    private Boolean isActive;
    private String username;
    private String password;
    private String addtioninfo;
    private boolean isLogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(Integer checkpointId) {
        this.checkpointId = checkpointId;
    }

    public String getCheckpointName() {
        return checkpointName;
    }

    public void setCheckpointName(String checkpointName) {
        this.checkpointName = checkpointName;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getpOSId() {
        return pOSId;
    }

    public void setpOSId(String pOSId) {
        this.pOSId = pOSId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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

    public String getAddtioninfo() {
        return addtioninfo;
    }

    public void setAddtioninfo(String addtioninfo) {
        this.addtioninfo = addtioninfo;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
