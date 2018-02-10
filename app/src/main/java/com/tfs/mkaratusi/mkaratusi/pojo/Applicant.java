
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Applicant {

    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("adress")
    @Expose
    private String adress;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("isTanzanian")
    @Expose
    private Boolean isTanzanian;
    @SerializedName("iDtype")
    @Expose
    private String iDtype;
    @SerializedName("idNumber")
    @Expose
    private String idNumber;
    @SerializedName("idIssuePlace")
    @Expose
    private String idIssuePlace;
    @SerializedName("idExpiryDate")
    @Expose
    private String idExpiryDate;
    @SerializedName("financialYearId")
    @Expose
    private Integer financialYearId;
    @SerializedName("financialYear")
    @Expose
    private FinancialYear financialYear;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsTanzanian() {
        return isTanzanian;
    }

    public void setIsTanzanian(Boolean isTanzanian) {
        this.isTanzanian = isTanzanian;
    }

    public String getIDtype() {
        return iDtype;
    }

    public void setIDtype(String iDtype) {
        this.iDtype = iDtype;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdIssuePlace() {
        return idIssuePlace;
    }

    public void setIdIssuePlace(String idIssuePlace) {
        this.idIssuePlace = idIssuePlace;
    }

    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    public void setIdExpiryDate(String idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    public Integer getFinancialYearId() {
        return financialYearId;
    }

    public void setFinancialYearId(Integer financialYearId) {
        this.financialYearId = financialYearId;
    }

    public FinancialYear getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(FinancialYear financialYear) {
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
