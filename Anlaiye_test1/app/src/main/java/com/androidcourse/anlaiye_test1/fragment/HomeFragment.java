package com.androidcourse.anlaiye_test1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.StoreActivity;
import com.androidcourse.anlaiye_test1.adapter.StoreListAdapter;
import com.androidcourse.anlaiye_test1.entity.DataService;


public class HomeFragment extends Fragment {

    private View rootView;
    private RecyclerView storeRecyclerView;
    private StoreListAdapter mStoreListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        //初始化控件
        storeRecyclerView = rootView.findViewById(R.id.store);


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mStoreListAdapter = new StoreListAdapter();
        storeRecyclerView.setAdapter(mStoreListAdapter);

        //加载数据
        mStoreListAdapter.setListData(DataService.getStoreListData());

        //recycler点击事件
        mStoreListAdapter.setmOnItemClickListener(new StoreListAdapter.onItemClickListener() {
            @Override
            public void onItemClick() {
                //跳转
                Intent intent = new Intent(getActivity(), StoreActivity.class);
                startActivity(intent);
            }
        });

    }
}