package com.androidcourse.anlaiye_test1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.entity.StoreInfo;

import java.util.ArrayList;
import java.util.List;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.MyHolder> {

    private List<StoreInfo> mStoreInfo = new ArrayList<>();
    public  void setListData(List<StoreInfo> list){
        this.mStoreInfo = list;
        //刷新
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_list, null);
        return new MyHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定数据
        StoreInfo storeInfo = mStoreInfo.get(position);

        holder.store_img.setImageResource(storeInfo.getStore_img());
        holder.store_title.setText(storeInfo.getStore_title());
        holder.store_details.setText(storeInfo.getStore_details());
        holder.store_num.setText(storeInfo.getStore_num());
        holder.store_num.setText(storeInfo.getStore_num());
    }

    @Override
    public int getItemCount() {
        return mStoreInfo.size();
    }

    static  class MyHolder extends RecyclerView.ViewHolder{

        ImageView store_img;
        TextView store_title;
        TextView store_price;
        TextView store_num;
        TextView store_details;
        public MyHolder(@NonNull View itemView){
            super(itemView);

            store_img = itemView.findViewById(R.id.store_img);
            store_title = itemView.findViewById(R.id.store_title);
            store_num = itemView.findViewById(R.id.store_num);
            store_price = itemView.findViewById(R.id.store_price);
            store_details = itemView.findViewById(R.id.store_details);
        }
    }
}
