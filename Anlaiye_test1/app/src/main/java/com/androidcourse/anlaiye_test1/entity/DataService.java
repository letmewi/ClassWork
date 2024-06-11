package com.androidcourse.anlaiye_test1.entity;

import com.androidcourse.anlaiye_test1.R;

import java.util.ArrayList;
import java.util.List;

public class DataService {



    public static List<StoreInfo> getStoreListData(){
        List<StoreInfo> list = new ArrayList<>();

        list.add(new StoreInfo(0, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(1, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(2, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(3, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(4, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(5, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(6, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(7, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(8, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        list.add(new StoreInfo(9, R.drawable.store,"车记片皮烤鸭卷","外送","起送价￥0配送费￥0起","月售237单"));
        return list;
    }

    public static List<ProductInfo> getProductListData(int position){
        List<ProductInfo> list = new ArrayList<>();
        if (position == 0){
            list.add(new ProductInfo(0,R.drawable.store,"一荤二素套餐", 26,"销量：259",R.drawable.add));
        } else if (position == 1) {
            list.add(new ProductInfo(1,R.drawable.store,"二荤三素套餐", 26,"销量：259",R.drawable.add));
        } else if (position == 2) {
            list.add(new ProductInfo(2,R.drawable.store,"三荤四素套餐", 26,"销量：259",R.drawable.add));
        } else if (position == 3) {
            list.add(new ProductInfo(3,R.drawable.store,"四荤五素套餐", 26,"销量：259",R.drawable.add));
        } else if (position == 4) {
            list.add(new ProductInfo(4,R.drawable.store,"五荤六素套餐", 26,"销量：259",R.drawable.add));
        }
        return list;
    }

}
