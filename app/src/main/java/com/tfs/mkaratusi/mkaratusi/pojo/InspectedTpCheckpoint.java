
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InspectedTpCheckpoint {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("TransitPassId")
    @Expose
    private Integer transitPassId;
    @SerializedName("Checkpoint")
    @Expose
    private String checkpoint;
    @SerializedName("InspectedOfficer")
    @Expose
    private String inspectedOfficer;
    @SerializedName("InspectionStatus")
    @Expose
    private Boolean inspectionStatus;
    @SerializedName("AdditionInformation")
    @Expose
    private String additionInformation;
    @SerializedName("ActionTaken")
    @Expose
    private Object actionTaken;

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

    public String getInspectedOfficer() {
        return inspectedOfficer;
    }

    public void setInspectedOfficer(String inspectedOfficer) {
        this.inspectedOfficer = inspectedOfficer;
    }

    public Boolean getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(Boolean inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public String getAdditionInformation() {
        return additionInformation;
    }

    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation;
    }

    public Object getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(Object actionTaken) {
        this.actionTaken = actionTaken;
    }

}
