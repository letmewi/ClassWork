package com.androidcourse.anlaiye_test1.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.adapter.OrderListAdapter;
import com.androidcourse.anlaiye_test1.entity.OrderDataService;


public class OrderFragment extends Fragment {

    private View rootView;

    private RecyclerView orderRecyclerView;

    private OrderListAdapter mOrderListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_order, container, false);

        //初始化控件
        orderRecyclerView = rootView.findViewById(R.id.order_view);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mOrderListAdapter = new OrderListAdapter();
        orderRecyclerView.setAdapter(mOrderListAdapter);

        //加载数据
        mOrderListAdapter.setListData(OrderDataService.getListData());
    }
}