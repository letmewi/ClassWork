package com.androidcourse.anlaiye_test1.entity;

public class StoreInfo {
    private int store_id;
    private int store_img;
    private String store_title;
    private String store_details;

    private String store_price;

    private String store_num;

    public StoreInfo(int store_id, int store_img, String store_title, String store_details) {
        this.store_id = store_id;
        this.store_img = store_img;
        this.store_title = store_title;
        this.store_details = store_details;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }


    public int getStore_img() {
        return store_img;
    }

    public void setStore_img(int store_img) {
        this.store_img = store_img;
    }

    public String getStore_title() {
        return store_title;
    }

    public void setStore_title(String store_title) {
        this.store_title = store_title;
    }

    public String getStore_details() {
        return store_details;
    }

    public void setStore_details(String store_details) {
        this.store_details = store_details;
    }

    public StoreInfo(int store_id, int store_img, String store_title, String store_details, String store_price, String store_num) {
        this.store_id = store_id;
        this.store_img = store_img;
        this.store_title = store_title;
        this.store_details = store_details;
        this.store_price = store_price;
        this.store_num = store_num;
    }

    public String getStore_price() {
        return store_price;
    }

    public void setStore_price(String store_price) {
        this.store_price = store_price;
    }

    public String getStore_num() {
        return store_num;
    }

    public void setStore_num(String store_num) {
        this.store_num = store_num;
    }
}
