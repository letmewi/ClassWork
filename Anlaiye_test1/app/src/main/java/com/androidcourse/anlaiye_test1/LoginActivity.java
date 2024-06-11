package com.androidcourse.anlaiye_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.androidcourse.anlaiye_test1.db.UserDbHelper;
import com.androidcourse.anlaiye_test1.entity.UserInfo;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private CheckBox rm_password;
    private boolean is_login;

    private SharedPreferences mSharedPreferences;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        rm_password = findViewById(R.id.remember_password);

        mSharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        //记住密码状态确认
        is_login = mSharedPreferences.getBoolean("is_login",false);
        if (is_login){
            String username = mSharedPreferences.getString("username",null);
            String password = mSharedPreferences.getString("password",null);
            et_username.setText(username);
            et_password.setText(password);
            rm_password.setChecked(true);
        }

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
                    if(login!=null){
                        if (username.equals(login.getUsername())&& password.equals(login.getPassword())){

                            SharedPreferences.Editor editor = mSharedPreferences.edit();
                            editor.putString("username",username);
                            editor.putString("password",password);
                            editor.putBoolean("is_login",is_login);
                            editor.commit();

                            //保存登录用户信息
                            UserInfo.setsUserInfo(login);

                            //登录成功
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(LoginActivity.this, "该账号暂未注册", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        //记住密码
        rm_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                is_login = isChecked;
            }
        });

        //点击短信登录
        findViewById(R.id.smsLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取接收者号码
                String recipient = "2252234"; // 替换为实际的接收者号码

                // 生成随机四位数字
                String randomCode = generateRandomCode();

                // 启动短信应用并填入接收者和短信内容
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:" + recipient));
                smsIntent.putExtra("sms_body",  randomCode);
                startActivity(smsIntent);
            }
        });
    }

    // 生成随机四位数字
    private String generateRandomCode() {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000; // 生成1000到9999之间的随机数
        return String.valueOf(randomNumber);
    }
}
