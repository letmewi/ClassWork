package com.androidcourse.anlaiye_test1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.StoreActivity;
import com.androidcourse.anlaiye_test1.adapter.OrderListAdapter;
import com.androidcourse.anlaiye_test1.db.CarDbHelper;
import com.androidcourse.anlaiye_test1.db.OrderDbHelper;
import com.androidcourse.anlaiye_test1.entity.CarInfo;
import com.androidcourse.anlaiye_test1.entity.OrderDataService;
import com.androidcourse.anlaiye_test1.entity.OrderInfo;
import com.androidcourse.anlaiye_test1.entity.UserInfo;

import java.util.List;


public class OrderFragment extends Fragment {

    private View rootView;

    private RecyclerView orderRecyclerView;

    private OrderListAdapter mOrderListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_order, container, false);

        //初始化控件
        orderRecyclerView = rootView.findViewById(R.id.order_view);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mOrderListAdapter = new OrderListAdapter(getActivity());
        orderRecyclerView.setAdapter(mOrderListAdapter);

        //加载数据
//        mOrderListAdapter.setListData(OrderDataService.getListData());

        dataLoad();


    }
    public void dataLoad(){
            UserInfo userInfo = UserInfo.getsUserInfo();
            if (null!=userInfo){
                List<OrderInfo> orderInfos = OrderDbHelper.getInstance(getActivity()).queryOrderListData(userInfo.getUsername());
                mOrderListAdapter.setOrderList(orderInfos);

        }
    }

}