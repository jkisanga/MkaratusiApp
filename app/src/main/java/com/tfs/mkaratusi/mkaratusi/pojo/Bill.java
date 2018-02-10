
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bill {

    @SerializedName("ApplicantId")
    @Expose
    private Integer applicantId;
    @SerializedName("StationId")
    @Expose
    private Integer stationId;
    @SerializedName("FinancialYearId")
    @Expose
    private Integer financialYearId;
    @SerializedName("IssuedDate")
    @Expose
    private String issuedDate;
    @SerializedName("ExpiredDate")
    @Expose
    private String expiredDate;
    @SerializedName("ControlNumber")
    @Expose
    private Object controlNumber;
    @SerializedName("BillAmount")
    @Expose
    private double billAmount;
    @SerializedName("PaidAmount")
    @Expose
    private Integer paidAmount;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("PaidDate")
    @Expose
    private Object paidDate;
    @SerializedName("IsCanceled")
    @Expose
    private Boolean isCanceled;
    @SerializedName("Reason")
    @Expose
    private Object reason;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Applicant")
    @Expose
    private Applicant applicant;
    @SerializedName("Station")
    @Expose
    private Station station;
    @SerializedName("FinancialYear")
    @Expose
    private FinancialYear_ financialYear;
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

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getFinancialYearId() {
        return financialYearId;
    }

    public void setFinancialYearId(Integer financialYearId) {
        this.financialYearId = financialYearId;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Object getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Object controlNumber) {
        this.controlNumber = controlNumber;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Object getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Object paidDate) {
        this.paidDate = paidDate;
    }

    public Boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public Object getReason() {
        return reason;
    }

    public void setReason(Object reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public FinancialYear_ getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(FinancialYear_ financialYear) {
        this.financialYear = financialYear;
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
