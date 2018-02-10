
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillPrint {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("ControlNumber")
    @Expose
    private Object controlNumber;
    @SerializedName("PayerName")
    @Expose
    private String payerName;
    @SerializedName("PayerAddress")
    @Expose
    private String payerAddress;
    @SerializedName("PayerPhone")
    @Expose
    private String payerPhone;
    @SerializedName("Station")
    @Expose
    private String station;
    @SerializedName("StationAddress")
    @Expose
    private String stationAddress;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("IssuedDate")
    @Expose
    private String issuedDate;
    @SerializedName("ExpireDate")
    @Expose
    private String expireDate;
    @SerializedName("BilledAmount")
    @Expose
    private Integer billedAmount;
    @SerializedName("BillId")
    @Expose
    private Integer billId;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("ItemDescription")
    @Expose
    private String itemDescription;
    @SerializedName("Amount")
    @Expose
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Object controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerAddress() {
        return payerAddress;
    }

    public void setPayerAddress(String payerAddress) {
        this.payerAddress = payerAddress;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Integer getBilledAmount() {
        return billedAmount;
    }

    public void setBilledAmount(Integer billedAmount) {
        this.billedAmount = billedAmount;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
