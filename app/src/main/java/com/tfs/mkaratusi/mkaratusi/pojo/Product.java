
package com.tfs.mkaratusi.mkaratusi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("TransitPassId")
    @Expose
    private Integer transitPassId;
    @SerializedName("Item")
    @Expose
    private String item;
    @SerializedName("UnitMeasure")
    @Expose
    private String unitMeasure;
    @SerializedName("Specie")
    @Expose
    private String specie;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("Size")
    @Expose
    private Object size;

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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

}
