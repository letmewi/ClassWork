package com.androidcourse.anlaiye_test1.entity;

public class ProductInfo {
    private int p_id;
    private int p_img;
    private String p_title;
    private int p_price;
    private String p_num;

    public String getP_num() {
        return p_num;
    }

    public void setP_num(String p_num) {
        this.p_num = p_num;
    }

    public ProductInfo(int p_id, int p_img, String p_title, int p_price, String p_num) {
        this.p_id = p_id;
        this.p_img = p_img;
        this.p_title = p_title;
        this.p_price = p_price;
        this.p_num = p_num;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getP_img() {
        return p_img;
    }

    public void setP_img(int p_img) {
        this.p_img = p_img;
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }
}
