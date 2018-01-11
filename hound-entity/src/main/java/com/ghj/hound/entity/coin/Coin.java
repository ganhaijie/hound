package com.ghj.hound.entity.coin;

import java.util.Date;

public class Coin {

    private Integer id;

    private String bourse;

    private String currency;

    private Double price;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBourse() {
        return bourse;
    }

    public void setBourse(String bourse) {
        this.bourse = bourse;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
