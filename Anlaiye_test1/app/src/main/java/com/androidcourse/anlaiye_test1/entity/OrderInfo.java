package com.androidcourse.anlaiye_test1.entity;

public class OrderInfo {
    private int order_id;
    private int order_img;
    private String order_title;
    private int order_price;
    private int order_count;

    private String address;
    private String phone;
    private String order_again;


    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_img() {
        return order_img;
    }

    public void setOrder_img(int order_img) {
        this.order_img = order_img;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }


    public int getOrder_price() {
        return order_price;
    }

    public String getOrder_again() {
        return order_again;
    }

    public void setOrder_again(String order_again) {
        this.order_again = order_again;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }


    public OrderInfo(int order_id, String userName, int order_img, String order_title, int order_price, int order_count, String address, String phone) {
        this.order_id = order_id;
        this.order_img = order_img;
        this.order_title = order_title;
        this.order_price = order_price;
        this.order_count = order_count;
        this.address = address;
        this.phone = phone;
    }
}
