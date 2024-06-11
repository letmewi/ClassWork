package com.androidcourse.anlaiye_test1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.StoreActivity;
import com.androidcourse.anlaiye_test1.entity.OrderInfo;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyHolder> {

    private List<OrderInfo> mOrderInfo = new ArrayList<>();
    public OrderListAdapter(Context context){}

    public void setListData(List<OrderInfo> list){
        this.mOrderInfo = list;
        //刷新
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list,null);
        return new MyHolder(view);
    }



    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定数据
        OrderInfo orderInfo = mOrderInfo.get(position);

        holder.order_img.setImageResource(orderInfo.getOrder_img());
        holder.order_title.setText(orderInfo.getOrder_title());
        holder.order_count.setText("x"+orderInfo.getOrder_count());
        holder.order_price.setText("￥"+orderInfo.getOrder_price()+"");
//        holder.order_again.setText(orderInfo.getOrder_again());
    }

    @Override
    public int getItemCount() {
        return mOrderInfo.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView order_img;
        TextView order_title;

        TextView order_price;
        TextView order_count;

        Button order_again;

        public MyHolder(@NonNull View itemView){
            super(itemView);

            order_img = itemView.findViewById(R.id.order_img);
            order_title = itemView.findViewById(R.id.order_title);
            order_count = itemView.findViewById(R.id.order_count);
            order_price = itemView.findViewById(R.id.order_price);
            order_again = itemView.findViewById(R.id.order_again);


        }
    }
    public void setOrderList(List<OrderInfo> list){
        this.mOrderInfo = list;

        notifyDataSetChanged();

    }

}
