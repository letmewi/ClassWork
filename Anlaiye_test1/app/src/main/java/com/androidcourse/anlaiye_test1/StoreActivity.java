package com.androidcourse.anlaiye_test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidcourse.anlaiye_test1.adapter.LeftListAdapter;
import com.androidcourse.anlaiye_test1.adapter.RightListAdapter;
import com.androidcourse.anlaiye_test1.db.CarDbHelper;
import com.androidcourse.anlaiye_test1.entity.DataService;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity {
    private RecyclerView leftListView;
    private RecyclerView rightListView;
    private LeftListAdapter mLeftListAdapter;
    private RightListAdapter mRightListAdapter;

    private List<String> leftDataList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        //初始化
        leftListView = findViewById(R.id.left_list);
        rightListView = findViewById(R.id.right_list);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        leftDataList.add("新品上市");
        leftDataList.add("限时优惠");
        leftDataList.add("经典王牌");
        leftDataList.add("小食荟萃");
        leftDataList.add("甜品饮料");

        mLeftListAdapter = new LeftListAdapter(leftDataList);
        leftListView.setAdapter(mLeftListAdapter);

        mRightListAdapter = new RightListAdapter(this);
        rightListView.setAdapter(mRightListAdapter);
        //默认加载新品上市
        mRightListAdapter.setListData(DataService.getProductListData(0));

        //recycler点击事件
        mLeftListAdapter.setleftListOnClickIteListener(new LeftListAdapter.LeftListOnClickItemListener() {
            @Override
            public void onItemClick(int position) {
                mLeftListAdapter.setCurrentIndex(position);

                //点击左侧栏切换
                mRightListAdapter.setListData(DataService.getProductListData(position));
            }
        });



    }
}