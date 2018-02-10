
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("revenueSourceId")
    @Expose
    private Integer revenueSourceId;
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("registrationFee")
    @Expose
    private Integer registrationFee;
    @SerializedName("revenue")
    @Expose
    private Object revenue;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("deleterUserId")
    @Expose
    private Object deleterUserId;
    @SerializedName("deletionTime")
    @Expose
    private Object deletionTime;
    @SerializedName("lastModificationTime")
    @Expose
    private Object lastModificationTime;
    @SerializedName("lastModifierUserId")
    @Expose
    private Object lastModifierUserId;
    @SerializedName("creationTime")
    @Expose
    private String creationTime;
    @SerializedName("creatorUserId")
    @Expose
    private Object creatorUserId;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRevenueSourceId() {
        return revenueSourceId;
    }

    public void setRevenueSourceId(Integer revenueSourceId) {
        this.revenueSourceId = revenueSourceId;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Integer registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Object getRevenue() {
        return revenue;
    }

    public void setRevenue(Object revenue) {
        this.revenue = revenue;
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

    public Object getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Object creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
