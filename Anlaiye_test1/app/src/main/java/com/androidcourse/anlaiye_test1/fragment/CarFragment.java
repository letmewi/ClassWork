package com.androidcourse.anlaiye_test1.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.adapter.CarListAdapter;
import com.androidcourse.anlaiye_test1.db.CarDbHelper;
import com.androidcourse.anlaiye_test1.entity.CarInfo;
import com.androidcourse.anlaiye_test1.entity.ProductInfo;

import java.util.List;


public class CarFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private TextView sum_price;
    private Button sum;

    private CarListAdapter mCarListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_car, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView_car);
        sum_price = rootView.findViewById(R.id.sum_price);
        sum = rootView.findViewById(R.id.btn_sum);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //初始化Adapter
        mCarListAdapter = new CarListAdapter();

        recyclerView.setAdapter(mCarListAdapter);

        //recyclerview点击事件
        mCarListAdapter.setmOnItemClickListener(new CarListAdapter.onItemClickListener() {
            @Override
            public void onAddOnClick(CarInfo carInfo, int position) {
                //add
                CarDbHelper.getInstance(getActivity()).updataProductAdd(carInfo.getCar_id(),carInfo);
                dataLoad();
            }

            @Override
            public void onLessOnClick(CarInfo carInfo, int position) {
                //less
                CarDbHelper.getInstance(getActivity()).updataProductLess(carInfo.getCar_id(), carInfo);
                dataLoad();
            }

            @Override
            public void deleteOnClick(CarInfo carInfo, int position) {

                new AlertDialog.Builder(getActivity())
                        .setTitle("温馨提示")
                        .setMessage("确认是否要删除")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                CarDbHelper.getInstance(getActivity()).delete(carInfo.getCar_id()+"");
                                dataLoad();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })

                        .show();

            }
        });

        //结算点击事件
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dataLoad();
    }

    private void setSumData(List<CarInfo> list){

        int sumprice = 0;
        for(int i =0;i<list.size();i++){
            int price = list.get(i).getProduct_price()*list.get(i).getProduct_count();

            sumprice = sumprice+price;
        }

        //setdata
        sum_price.setText(sumprice+"");
    }

    public void dataLoad(){
        //获取数据
        List<CarInfo> carList = CarDbHelper.getInstance(getActivity()).quertCarList("zzz");
        //设置数据
        mCarListAdapter.setCarList(carList);

        setSumData(carList);
    }
}