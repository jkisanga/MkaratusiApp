
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrintTp {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("BillId")
    @Expose
    private Integer billId;
    @SerializedName("Applicant")
    @Expose
    private String applicant;
    @SerializedName("StationName")
    @Expose
    private Object stationName;
    @SerializedName("StationAddress")
    @Expose
    private Object stationAddress;
    @SerializedName("OrginalCountry")
    @Expose
    private String orginalCountry;
    @SerializedName("NoOfConsignment")
    @Expose
    private String noOfConsignment;
    @SerializedName("LisenceNo")
    @Expose
    private Object lisenceNo;
    @SerializedName("TransitPassNo")
    @Expose
    private String transitPassNo;
    @SerializedName("SourceForest")
    @Expose
    private Integer sourceForest;
    @SerializedName("IssuedDate")
    @Expose
    private String issuedDate;
    @SerializedName("ExpireDate")
    @Expose
    private String expireDate;
    @SerializedName("SourceName")
    @Expose
    private String sourceName;
    @SerializedName("DestinationName")
    @Expose
    private String destinationName;
    @SerializedName("VehcleNo")
    @Expose
    private String vehcleNo;
    @SerializedName("HummerNo")
    @Expose
    private String hummerNo;
    @SerializedName("HummerMaker")
    @Expose
    private String hummerMaker;
    @SerializedName("HummerStation")
    @Expose
    private Object hummerStation;
    @SerializedName("AdditionInformation")
    @Expose
    private String additionInformation;
    @SerializedName("CreatedUser")
    @Expose
    private String createdUser;
    @SerializedName("ControlNumber")
    @Expose
    private String controlNumber;
    @SerializedName("CreationTime")
    @Expose
    private String creationTime;
    @SerializedName("ItemId")
    @Expose
    private Integer itemId;
    @SerializedName("ItemDescription")
    @Expose
    private Object itemDescription;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("UnitMeasure")
    @Expose
    private Object unitMeasure;
    @SerializedName("Specie")
    @Expose
    private Object specie;
    @SerializedName("CheckpointId")
    @Expose
    private Integer checkpointId;
    @SerializedName("CheckpointName")
    @Expose
    private Object checkpointName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Object getStationName() {
        return stationName;
    }

    public void setStationName(Object stationName) {
        this.stationName = stationName;
    }

    public Object getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(Object stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getOrginalCountry() {
        return orginalCountry;
    }

    public void setOrginalCountry(String orginalCountry) {
        this.orginalCountry = orginalCountry;
    }

    public String getNoOfConsignment() {
        return noOfConsignment;
    }

    public void setNoOfConsignment(String noOfConsignment) {
        this.noOfConsignment = noOfConsignment;
    }

    public Object getLisenceNo() {
        return lisenceNo;
    }

    public void setLisenceNo(Object lisenceNo) {
        this.lisenceNo = lisenceNo;
    }

    public String getTransitPassNo() {
        return transitPassNo;
    }

    public void setTransitPassNo(String transitPassNo) {
        this.transitPassNo = transitPassNo;
    }

    public Integer getSourceForest() {
        return sourceForest;
    }

    public void setSourceForest(Integer sourceForest) {
        this.sourceForest = sourceForest;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getVehcleNo() {
        return vehcleNo;
    }

    public void setVehcleNo(String vehcleNo) {
        this.vehcleNo = vehcleNo;
    }

    public String getHummerNo() {
        return hummerNo;
    }

    public void setHummerNo(String hummerNo) {
        this.hummerNo = hummerNo;
    }

    public String getHummerMaker() {
        return hummerMaker;
    }

    public void setHummerMaker(String hummerMaker) {
        this.hummerMaker = hummerMaker;
    }

    public Object getHummerStation() {
        return hummerStation;
    }

    public void setHummerStation(Object hummerStation) {
        this.hummerStation = hummerStation;
    }

    public String getAdditionInformation() {
        return additionInformation;
    }

    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Object getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(Object itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Object getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(Object unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public Object getSpecie() {
        return specie;
    }

    public void setSpecie(Object specie) {
        this.specie = specie;
    }

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(Integer checkpointId) {
        this.checkpointId = checkpointId;
    }

    public Object getCheckpointName() {
        return checkpointName;
    }

    public void setCheckpointName(Object checkpointName) {
        this.checkpointName = checkpointName;
    }

}
