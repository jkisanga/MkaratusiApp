
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("ZoneId")
    @Expose
    private Integer zoneId;
    @SerializedName("RegionId")
    @Expose
    private Integer regionId;
    @SerializedName("ParentId")
    @Expose
    private Integer parentId;
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
    private Object creatorUserId;
    @SerializedName("Region")
    @Expose
    private Region region;
    @SerializedName("Zone")
    @Expose
    private Zone zone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

}
