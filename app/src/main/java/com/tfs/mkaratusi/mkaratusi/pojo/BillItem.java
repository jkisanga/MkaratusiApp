
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillItem {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("BillId")
    @Expose
    private Integer billId;
    @SerializedName("ActivityId")
    @Expose
    private Integer activityId;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Loyality")
    @Expose
    private Integer loyality;
    @SerializedName("TFF")
    @Expose
    private Integer tFF;
    @SerializedName("LMDA")
    @Expose
    private Integer lMDA;
    @SerializedName("VAT")
    @Expose
    private Integer vAT;
    @SerializedName("CESS")
    @Expose
    private Integer cESS;
    @SerializedName("TP")
    @Expose
    private Integer tP;
    @SerializedName("DataSheet")
    @Expose
    private Integer dataSheet;
    @SerializedName("Others")
    @Expose
    private Integer others;
    @SerializedName("Total")
    @Expose
    private double total;
    @SerializedName("EquvAmont")
    @Expose
    private Integer equvAmont;
    @SerializedName("MiscAmont")
    @Expose
    private Integer miscAmont;
    @SerializedName("GfsCode")
    @Expose
    private Integer gfsCode;

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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLoyality() {
        return loyality;
    }

    public void setLoyality(Integer loyality) {
        this.loyality = loyality;
    }

    public Integer getTFF() {
        return tFF;
    }

    public void setTFF(Integer tFF) {
        this.tFF = tFF;
    }

    public Integer getLMDA() {
        return lMDA;
    }

    public void setLMDA(Integer lMDA) {
        this.lMDA = lMDA;
    }

    public Integer getVAT() {
        return vAT;
    }

    public void setVAT(Integer vAT) {
        this.vAT = vAT;
    }

    public Integer getCESS() {
        return cESS;
    }

    public void setCESS(Integer cESS) {
        this.cESS = cESS;
    }

    public Integer getTP() {
        return tP;
    }

    public void setTP(Integer tP) {
        this.tP = tP;
    }

    public Integer getDataSheet() {
        return dataSheet;
    }

    public void setDataSheet(Integer dataSheet) {
        this.dataSheet = dataSheet;
    }

    public Integer getOthers() {
        return others;
    }

    public void setOthers(Integer others) {
        this.others = others;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getEquvAmont() {
        return equvAmont;
    }

    public void setEquvAmont(Integer equvAmont) {
        this.equvAmont = equvAmont;
    }

    public Integer getMiscAmont() {
        return miscAmont;
    }

    public void setMiscAmont(Integer miscAmont) {
        this.miscAmont = miscAmont;
    }

    public Integer getGfsCode() {
        return gfsCode;
    }

    public void setGfsCode(Integer gfsCode) {
        this.gfsCode = gfsCode;
    }

}
