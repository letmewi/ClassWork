package com.androidcourse.anlaiye_test1.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidcourse.anlaiye_test1.R;

import java.util.ArrayList;
import java.util.List;

public class LeftListAdapter extends RecyclerView.Adapter<LeftListAdapter.MyHolder>{

    private List<String> dataList = new ArrayList<>();

    private int currentIndex = 0;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("ResourceType") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        //绑定数据
        String name = dataList.get(position);
        holder.name.setText(name);

        //分类选择点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mleftListOnClickIteListener!=null){
                    mleftListOnClickIteListener.onItemClick(position);
                }
            }
        });

        if (currentIndex == position){
            holder.itemView.setBackgroundResource(R.drawable.type_selector_bg);
        }else {
            holder.itemView.setBackgroundResource(R.drawable.type_selector_normal);
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        TextView name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }

    public LeftListAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    private LeftListOnClickItemListener mleftListOnClickIteListener;


    public void setleftListOnClickIteListener(LeftListOnClickItemListener mleftListOnClickIteListener) {
        this.mleftListOnClickIteListener = mleftListOnClickIteListener;
    }

    public interface LeftListOnClickItemListener{
        void onItemClick(int position);
    }

    public  void setCurrentIndex(int position){
        this.currentIndex = position;
        //一定要写，刷新
        notifyDataSetChanged();
    }
}
