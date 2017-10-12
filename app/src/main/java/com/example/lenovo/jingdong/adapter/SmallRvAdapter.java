package com.example.lenovo.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.bean.SmallBean;

import java.util.List;

/**
 * Created by lenovo on 2017/10/11.
 */

public class SmallRvAdapter extends RecyclerView.Adapter<SmallRvAdapter.MyViewHolder> {
private Context context;
private List<SmallBean> list;

    public SmallRvAdapter(Context context, List<SmallBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.smallrecycleitme,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_small.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.iv_small);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private  TextView tv_small;
        private   ImageView iv_small;

        public MyViewHolder(View itemView) {
            super(itemView);
             tv_small= itemView.findViewById(R.id.tv_small);
            iv_small = itemView.findViewById(R.id.iv_small);
        }
    }
}
