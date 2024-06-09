package com.androidcourse.anlaiye_test1.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.androidcourse.anlaiye_test1.entity.UserInfo;

public class UserDbHelper extends SQLiteOpenHelper {

    private static UserDbHelper uHelper;
    private static  final String DB_NAME = "user.db";

    private static final int VERSION = 1;
    public UserDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //创建单例，供使用调用该类里增删查改的方法
    public synchronized static UserDbHelper getInstance(Context context){
        if(null == uHelper){
            uHelper = new UserDbHelper(context,DB_NAME,null,VERSION);
        }
        return uHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //建表user_table
        db.execSQL("create table user_table(user_id integer primary key autoincrement,"+
                "username text,"+
                "password text,"+
                "nickname text"+
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //用户注册
    public int register(String username,String password,String nickname){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("nickname",nickname);

        int insert = (int) db.insert("user_table","values(null,?,?,?)",values);
        db.close();
        return  insert;
    }

    //用户登录
    @SuppressLint("Range")
    public UserInfo login(String username){
        SQLiteDatabase db = getReadableDatabase();
        UserInfo userInfo = null;
        String sql = "select user_id,username,password,nickname from user_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        if(cursor.moveToNext()){
            int user_id = cursor.getInt(cursor.getColumnIndex("user_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            userInfo = new UserInfo(user_id,name,password,nickname);
        }
        cursor.close();;
        db.close();
        return userInfo;
    }
}
