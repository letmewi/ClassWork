package com.androidcourse.anlaiye_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidcourse.anlaiye_test1.db.UserDbHelper;
import com.androidcourse.anlaiye_test1.entity.UserInfo;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        //点击注册
        findViewById(R.id.toRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转注册界面
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //点击登录
        findViewById(R.id.Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                }else {
                    UserInfo login = UserDbHelper.getInstance(LoginActivity.this).login(username);
                    if (username.equals(login.getUsername())&& password.equals(login.getPassword())){
                        //登录成功
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}