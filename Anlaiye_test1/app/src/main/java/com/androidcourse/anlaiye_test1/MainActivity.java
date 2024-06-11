package com.androidcourse.anlaiye_test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.androidcourse.anlaiye_test1.fragment.CarFragment;
import com.androidcourse.anlaiye_test1.fragment.HomeFragment;
import com.androidcourse.anlaiye_test1.fragment.MineFragment;
import com.androidcourse.anlaiye_test1.fragment.OrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //创建4个 Fragment
    private HomeFragment mHomeFragment;
    private OrderFragment mOrderFragment;
    private MineFragment mMineFragment;
    private CarFragment mCarFragment;

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);
        //设置点击事件
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    selectedFragment(0);
                } else if (item.getItemId()==R.id.car) {
                    selectedFragment(1);
                }else if (item.getItemId()==R.id.order) {
                    selectedFragment(2);
                }
                else {
                    selectedFragment(3);
                }
                return true;
            }
        });

        selectedFragment(0);

    }

    //设置默认选中首页
    private void selectedFragment(int position){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if(position == 0){
            if(mHomeFragment == null){
                mHomeFragment = new HomeFragment();
                fragmentTransaction.add(R.id.content,mHomeFragment);
            }else {
                fragmentTransaction.show(mHomeFragment);
            }
        } else if (position == 1) {
            if(mCarFragment == null){
                mCarFragment = new CarFragment();
                fragmentTransaction.add(R.id.content,mCarFragment);
            }else {
                fragmentTransaction.show(mCarFragment);
                mCarFragment.dataLoad();
            }
        }else if (position == 2) {
            if(mOrderFragment == null){
                mOrderFragment = new OrderFragment();
                fragmentTransaction.add(R.id.content,mOrderFragment);
            }else {
                fragmentTransaction.show(mOrderFragment);
            }
        }
        else {
            if(mMineFragment == null){
                mMineFragment = new MineFragment();
                fragmentTransaction.add(R.id.content,mMineFragment);
            }else {
                fragmentTransaction.show(mMineFragment);
            }
        }

        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(mHomeFragment!=null){
            fragmentTransaction.hide(mHomeFragment);
        }
        if(mCarFragment != null){
            fragmentTransaction.hide(mCarFragment);
        }
        if(mOrderFragment!=null){
            fragmentTransaction.hide(mOrderFragment);
        }
        if(mMineFragment!=null){
            fragmentTransaction.hide(mMineFragment);
        }
    }
}