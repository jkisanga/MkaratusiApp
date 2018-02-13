
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PosUser {

    @SerializedName("UserId")
    @Expose
    private Integer userId;
    @SerializedName("CheckpointId")
    @Expose
    private Integer checkpointId;
    @SerializedName("CheckpointName")
    @Expose
    private String checkpointName;
    @SerializedName("OfficerName")
    @Expose
    private String officerName;
    @SerializedName("POSId")
    @Expose
    private String pOSId;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Addtioninfo")
    @Expose
    private String addtioninfo;
    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("DeleterUserId")
    @Expose
    private Object deleterUserId;
    @SerializedName("DeletionTime")
    @Expose
    private Object deletionTime;
    @SerializedName("LastModificationTime")
    @Expose
    private Object lastModificationTime;
    @SerializedName("LastModifierUserId")
    @Expose
    private Object lastModifierUserId;
    @SerializedName("CreationTime")
    @Expose
    private String creationTime;
    @SerializedName("CreatorUserId")
    @Expose
    private Integer creatorUserId;
    @SerializedName("Id")
    @Expose
    private Integer id;

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

    public String getPOSId() {
        return pOSId;
    }

    public void setPOSId(String pOSId) {
        this.pOSId = pOSId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Object getDeleterUserId() {
        return deleterUserId;
    }

    public void setDeleterUserId(Object deleterUserId) {
        this.deleterUserId = deleterUserId;
    }

    public Object getDeletionTime() {
        return deletionTime;
    }

    public void setDeletionTime(Object deletionTime) {
        this.deletionTime = deletionTime;
    }

    public Object getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(Object lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public Object getLastModifierUserId() {
        return lastModifierUserId;
    }

    public void setLastModifierUserId(Object lastModifierUserId) {
        this.lastModifierUserId = lastModifierUserId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Integer creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
