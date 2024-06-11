package com.androidcourse.anlaiye_test1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidcourse.anlaiye_test1.R;
import com.androidcourse.anlaiye_test1.db.CarDbHelper;
import com.androidcourse.anlaiye_test1.entity.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class RightListAdapter extends RecyclerView.Adapter<RightListAdapter.MyHolder> {
    private static List<ProductInfo> mProductInfo = new ArrayList<>();
    private static Context context;

    public RightListAdapter(Context context) {
        this.context = context;
    }

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
        holder.add.setImageResource(productInfo.getAdd());
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
        ImageView add;
        TextView p_title;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            p_img = itemView.findViewById(R.id.p_img);
            p_num = itemView.findViewById(R.id.p_num);
            p_title = itemView.findViewById(R.id.p_title);
            p_price = itemView.findViewById(R.id.p_price);
            add = itemView.findViewById(R.id.add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ProductInfo productInfo = mProductInfo.get(position);
                        CarDbHelper dbHelper = CarDbHelper.getInstance(context);
                        int row = dbHelper.addCar("zzz", productInfo.getP_id(), productInfo.getP_img(), productInfo.getP_title(), productInfo.getP_price());
                        // 这里的 "username" 应该是实际用户名
                        if (row>0){
                            Toast.makeText(context, productInfo.getP_title() + " 已添加到购物车", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context, productInfo.getP_title() + " 添加失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }

    }
}
