package com.androidcourse.anlaiye_test1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.entity.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.MyHolder> {

    private List<CarInfo> mCarList = new ArrayList<>();

    public void setCarList(List<CarInfo> list){
        this.mCarList = list;
        //刷新
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        //绑定数据
        CarInfo carinfo = mCarList.get(position);
        holder.car_img.setImageResource(carinfo.getProduct_img());
        holder.car_store.setText(carinfo.getProduct_title());
        holder.car_price.setText(carinfo.getProduct_price()+"");
        holder.car_count.setText(carinfo.getProduct_count()+"");

        //设置加减点击事件
        holder.btn_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=mOnItemClickListener){
                    mOnItemClickListener.onLessOnClick(carinfo,position);
                }

            }
        });
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=mOnItemClickListener){
                    mOnItemClickListener.onAddOnClick(carinfo,position);
                }

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.deleteOnClick(carinfo,position);
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCarList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView car_img;
        TextView car_store;
        TextView car_price;
        TextView car_count;
        TextView btn_less;
        TextView btn_add;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            car_img = itemView.findViewById(R.id.car_img);
            car_store = itemView.findViewById(R.id.car_store);
            car_price = itemView.findViewById(R.id.car_price);
            car_count = itemView.findViewById(R.id.car_count);
            btn_less = itemView.findViewById(R.id.btn_less);
            btn_add = itemView.findViewById(R.id.btn_add);
        }
    }


    private onItemClickListener mOnItemClickListener;

    public void setmCarList(List<CarInfo> mCarList) {
        this.mCarList = mCarList;
    }

    public void setmOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface onItemClickListener{


        void onAddOnClick(CarInfo carInfo,int position);
        void onLessOnClick(CarInfo carInfo,int position);
        void deleteOnClick(CarInfo carInfo,int position);
    }
}
