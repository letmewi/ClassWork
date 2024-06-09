package com.androidcourse.anlaiye_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidcourse.anlaiye_test1.db.UserDbHelper;

public class RegisterActivity extends AppCompatActivity {


    private EditText et_username;
    private EditText et_password;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //初始化
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        //返回
        findViewById(R.id.toolbar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接销毁当前页面
                finish();
            }
        });

        //注册
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                }else {
                    int result = UserDbHelper.getInstance(RegisterActivity.this).register(username,password,"暂无");
                    if(result>0){
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}