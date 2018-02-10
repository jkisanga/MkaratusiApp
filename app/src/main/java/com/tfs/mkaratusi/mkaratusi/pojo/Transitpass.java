
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transitpass {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("ApplicantId")
    @Expose
    private Integer applicantId;
    @SerializedName("BillId")
    @Expose
    private Integer billId;
    @SerializedName("OrginalCountry")
    @Expose
    private Object orginalCountry;
    @SerializedName("NoOfConsignment")
    @Expose
    private Object noOfConsignment;
    @SerializedName("LisenceNo")
    @Expose
    private Object lisenceNo;
    @SerializedName("TransitPassNo")
    @Expose
    private Object transitPassNo;
    @SerializedName("SourceForest")
    @Expose
    private Integer sourceForest;
    @SerializedName("IssuedDate")
    @Expose
    private String issuedDate;
    @SerializedName("ExpireDate")
    @Expose
    private String expireDate;
    @SerializedName("ExpireDays")
    @Expose
    private Integer expireDays;
    @SerializedName("SourceName")
    @Expose
    private String sourceName;
    @SerializedName("DestinationId")
    @Expose
    private Integer destinationId;
    @SerializedName("DestinationName")
    @Expose
    private String destinationName;
    @SerializedName("VehcleNo")
    @Expose
    private String vehcleNo;
    @SerializedName("IssuerOfficer")
    @Expose
    private Integer issuerOfficer;
    @SerializedName("HummerNo")
    @Expose
    private String hummerNo;
    @SerializedName("HummerMaker")
    @Expose
    private String hummerMaker;
    @SerializedName("HummerStationId")
    @Expose
    private Object hummerStationId;
    @SerializedName("AdditionInformation")
    @Expose
    private String additionInformation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Object getOrginalCountry() {
        return orginalCountry;
    }

    public void setOrginalCountry(Object orginalCountry) {
        this.orginalCountry = orginalCountry;
    }

    public Object getNoOfConsignment() {
        return noOfConsignment;
    }

    public void setNoOfConsignment(Object noOfConsignment) {
        this.noOfConsignment = noOfConsignment;
    }

    public Object getLisenceNo() {
        return lisenceNo;
    }

    public void setLisenceNo(Object lisenceNo) {
        this.lisenceNo = lisenceNo;
    }

    public Object getTransitPassNo() {
        return transitPassNo;
    }

    public void setTransitPassNo(Object transitPassNo) {
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

    public Integer getExpireDays() {
        return expireDays;
    }

    public void setExpireDays(Integer expireDays) {
        this.expireDays = expireDays;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
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

    public Integer getIssuerOfficer() {
        return issuerOfficer;
    }

    public void setIssuerOfficer(Integer issuerOfficer) {
        this.issuerOfficer = issuerOfficer;
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

    public Object getHummerStationId() {
        return hummerStationId;
    }

    public void setHummerStationId(Object hummerStationId) {
        this.hummerStationId = hummerStationId;
    }

    public String getAdditionInformation() {
        return additionInformation;
    }

    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation;
    }


}
