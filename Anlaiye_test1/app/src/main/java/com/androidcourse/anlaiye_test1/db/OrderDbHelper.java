package com.androidcourse.anlaiye_test1.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.androidcourse.anlaiye_test1.entity.CarInfo;
import com.androidcourse.anlaiye_test1.entity.OrderInfo;
import com.androidcourse.anlaiye_test1.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class OrderDbHelper extends SQLiteOpenHelper {

    private static OrderDbHelper oHelper;
    private static  final String DB_NAME = "order.db";

    private static final int VERSION = 1;
    public OrderDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //创建单例，供使用调用该类里增删查改的方法
    public synchronized static OrderDbHelper getInstance(Context context){
        if(null == oHelper){
            oHelper = new OrderDbHelper(context,DB_NAME,null,VERSION);
        }
        return oHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //建表
        db.execSQL("create table order_table(order_id integer primary key autoincrement,"+
                "username text,"+
                "product_img integer,"+
                "product_title text,"+
                "product_price integer,"+
                "product_count integer,"+
                "address text,"+
                "phone text"+
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL("ALTER TABLE order_table ADD COLUMN order_id INTEGER PRIMARY KEY AUTOINCREMENT");
        }
    }

    //批量插入数据
    public void insertByAll(List<CarInfo> list, String address, String phone){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            for(int i=0;i< list.size();i++){
                ContentValues values = new ContentValues();
                values.put("username",list.get(i).getUsername());
                values.put("product_img",list.get(i).getProduct_img());
                values.put("product_title",list.get(i).getProduct_title());
                values.put("product_price",list.get(i).getProduct_price());
                values.put("product_count",list.get(i).getProduct_count());
                values.put("address",address);
                values.put("phone",phone);
                db.insert("order_table",null,values);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
//        db.close();
    }

    //查询数据
    @SuppressLint("Range")
    public List<OrderInfo> queryOrderListData(String username){
        SQLiteDatabase db = getReadableDatabase();
        List<OrderInfo> list = new ArrayList<>();
        String sql = "select order_id,username,product_img,product_title,product_price,product_count,address,phone from order_table where username=?";
        String[] selectionArgs={username};
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        while (cursor.moveToNext()){
            int order_id = cursor.getInt(cursor.getColumnIndex("order_id"));
            String userName = cursor.getString(cursor.getColumnIndex("username"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            list.add(new OrderInfo(order_id,userName,product_img,product_title,product_price,product_count,address,phone));
        }
        cursor.close();
//        db.close();
        Log.d("OrderDbHelper", "Query result size: " + list.size()); // 添加日志
        return  list;
    }
}
