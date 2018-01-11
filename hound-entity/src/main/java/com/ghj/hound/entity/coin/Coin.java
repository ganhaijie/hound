package com.ghj.hound.entity.coin;

import java.util.Date;

public class Coin {

    private Integer id;

    private String bhourse;

    private String currency;

    private Double price;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBhourse() {
        return bhourse;
    }

    public void setBhourse(String bhourse) {
        this.bhourse = bhourse;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
