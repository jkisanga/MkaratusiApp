
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckpointPrint {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("TransitPassId")
    @Expose
    private Integer transitPassId;
    @SerializedName("Checkpoint")
    @Expose
    private String checkpoint;
    @SerializedName("InspectionStatus")
    @Expose
    private Boolean inspectionStatus;
    @SerializedName("AdditionInformation")
    @Expose
    private Object additionInformation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTransitPassId() {
        return transitPassId;
    }

    public void setTransitPassId(Integer transitPassId) {
        this.transitPassId = transitPassId;
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    public Boolean getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(Boolean inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public Object getAdditionInformation() {
        return additionInformation;
    }

    public void setAdditionInformation(Object additionInformation) {
        this.additionInformation = additionInformation;
    }

}
