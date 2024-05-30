package com.androidcourse.anlaiye_test1.entity;

import com.androidcourse.anlaiye_test1.R;

import java.util.ArrayList;
import java.util.List;

public class DataService {



    public static List<StoreInfo> getListData(){
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
}
