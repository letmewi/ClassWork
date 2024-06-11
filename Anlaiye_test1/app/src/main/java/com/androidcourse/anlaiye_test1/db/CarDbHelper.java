package com.androidcourse.anlaiye_test1.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.androidcourse.anlaiye_test1.entity.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class CarDbHelper extends SQLiteOpenHelper {
    private static CarDbHelper cHelper;
    private static final String DB_NAME = "car.db";
    private static final int VERSION = 1;
    public CarDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //创建单例，供使用类里的方法
    public synchronized static CarDbHelper getInstance(Context context){
        if (null == cHelper){
            cHelper = new CarDbHelper(context,DB_NAME,null,VERSION);
        }
        return cHelper;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //建表
        db.execSQL("create table car_table(car_id integer primary key autoincrement,"+
                "username text,"+
                "product_id integer,"+
                "product_img integer,"+
                "product_title text,"+
                "product_price integer,"+
                "product_count integer"+
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //添加
    public int addCar(String username, int product_id, int product_img, String product_title, int product_price){
        //判断是否添加过商品，若添加过，只修改商品数量
        CarInfo addCar = isAddCar(username,product_id);
        if (addCar == null){
            //获取SQLiteDatabase实例
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            //填充占位符
            values.put("username",username);
            values.put("product_id",product_id);
            values.put("product_img",product_img);
            values.put("product_title",product_title);
            values.put("product_price",product_price);
            values.put("product_count",1);

            int insert = (int) db.insert("car_table","values(null,?,?,?,?,?,?)",values);
            db.close();
            return  insert;
        }else {
            return updataProductAdd(addCar.getCar_id(),addCar);
        }
    }
    //修改add
    public int updataProductAdd(int car_id, CarInfo carInfo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("product_count",carInfo.getProduct_count()+1);
        int update = db.update("car_table",values,"car_id=?",new String[]{car_id+""});
        db.close();;
        return update;
    }

    //修改less
    public int updataProductLess(int car_id, CarInfo carInfo){
        if (carInfo.getProduct_count()>=2){
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("product_count",carInfo.getProduct_count()-1);
            int update = db.update("car_table",values,"car_id=?",new String[]{car_id+""});
            db.close();;
            return update;
        }

        return 0;
    }
    //删除购物车商品
    public int delete(String car_id){
        SQLiteDatabase db = getWritableDatabase();

        int delete = db.delete("car_table","car_id=?",new String[]{car_id});

        db.close();;
        return delete;
    }
    //根据用户名和id判断是否添加过商品到购物车
    @SuppressLint("Range")
    public CarInfo isAddCar(String username,int product_id){
        SQLiteDatabase db = getReadableDatabase();
        CarInfo carInfo = null;
        String sql = "select car_id,username,product_id,product_img,product_title,product_price,product_count from car_table where username=? and product_id=?";
        String[] selectionArgs = {username,product_id+""};
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        if(cursor.moveToNext()){
            int car_id = cursor.getInt(cursor.getColumnIndex("car_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            int product_Id = cursor.getInt(cursor.getColumnIndex("product_id"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            carInfo = new CarInfo(car_id,name,product_Id,product_img,product_title,product_price,product_count);
        }
        cursor.close();;
        db.close();
        return carInfo;
    }

    //根据用户名查询购物车
    @SuppressLint("Range")
    public List<CarInfo> quertCarList(String username){
        SQLiteDatabase db = getReadableDatabase();
        List<CarInfo> list = new ArrayList<>();
        String sql = "select car_id,username,product_id,product_img,product_title,product_price,product_count from car_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        while (cursor.moveToNext()){
            int car_id = cursor.getInt(cursor.getColumnIndex("car_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            int product_Id = cursor.getInt(cursor.getColumnIndex("product_id"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            list.add(new CarInfo(car_id,name,product_Id,product_img,product_title,product_price,product_count));
        }
        cursor.close();;
        db.close();
        return list;
    }
}
