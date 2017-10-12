package com.example.lenovo.jingdong.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.bean.VpBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/10/8.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private List<VpBean> list;
    private Context context;;

    public RecycleAdapter(List<VpBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.fenleiitem2,null);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv1.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.iv1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv1;
        private ImageView iv1;
        public MyViewHolder(View itemView) {
           super(itemView);
            tv1= itemView.findViewById(R.id.tv1);
            iv1= itemView.findViewById(R.id.iv1);
        }
    }
}
