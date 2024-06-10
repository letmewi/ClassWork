package com.androidcourse.anlaiye_test1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.entity.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class RightListAdapter extends RecyclerView.Adapter<RightListAdapter.MyHolder> {
    private List<ProductInfo> mProductInfo = new ArrayList<>();

    public void setListData(List<ProductInfo> list){
        this.mProductInfo = list;

        //must刷新
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定数据
        ProductInfo productInfo = mProductInfo.get(position);
        holder.p_img.setImageResource(productInfo.getP_img());
        holder.p_title.setText(productInfo.getP_title());
        holder.p_num.setText(productInfo.getP_num());
        //只能设置文本类型
        holder.p_price.setText(productInfo.getP_price()+"");
    }

    @Override
    public int getItemCount() {
        return mProductInfo.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{

        ImageView p_img;
        TextView p_num;
        TextView p_price;
        TextView p_title;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            p_img = itemView.findViewById(R.id.p_img);
            p_num = itemView.findViewById(R.id.p_num);
            p_title = itemView.findViewById(R.id.p_title);
            p_price = itemView.findViewById(R.id.p_price);
        }
    }
}
