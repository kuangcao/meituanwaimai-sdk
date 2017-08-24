package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-11.
 */
public class Sku implements Serializable {

    private String sku_id;
    private String spec;
    private String upc;
    private Double price;
    private Integer stock;
    private String location_code;
    private Integer box_num;
    private Double box_price;
    private AvailableTimes available_times;

    public String getSku_id() {
        return sku_id;
    }

    public void setSku_id(String sku_id) {
        this.sku_id = sku_id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public AvailableTimes getAvailable_times() {
        return available_times;
    }

    public void setAvailable_times(AvailableTimes available_times) {
        this.available_times = available_times;
    }

    public Integer getBox_num() {
        return box_num;
    }

    public void setBox_num(Integer box_num) {
        this.box_num = box_num;
    }

    public Double getBox_price() {
        return box_price;
    }

    public void setBox_price(Double box_price) {
        this.box_price = box_price;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "sku_id='" + sku_id + '\'' +
                ", spec='" + spec + '\'' +
                ", upc='" + upc + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", location_code='" + location_code + '\'' +
                ", box_num=" + box_num +
                ", box_price=" + box_price +
                ", available_times=" + available_times +
                '}';
    }
}
