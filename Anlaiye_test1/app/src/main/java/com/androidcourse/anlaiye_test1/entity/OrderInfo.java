package com.androidcourse.anlaiye_test1.entity;

public class OrderInfo {
    private int order_id;
    private int order_img;
    private String order_title;
    private String order_time;
    private String order_price;
    private String order_again;

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

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_again() {
        return order_again;
    }

    public void setOrder_again(String order_again) {
        this.order_again = order_again;
    }

    public OrderInfo(int order_id, int order_img, String order_title, String order_time, String order_price, String order_again) {
        this.order_id = order_id;
        this.order_img = order_img;
        this.order_title = order_title;
        this.order_time = order_time;
        this.order_price = order_price;
        this.order_again = order_again;
    }
}
