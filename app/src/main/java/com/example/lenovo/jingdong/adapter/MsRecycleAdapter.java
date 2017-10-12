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
import com.example.lenovo.jingdong.bean.Bean;
import com.example.lenovo.jingdong.bean.MiaoShaBean2;
import com.example.lenovo.jingdong.bean.VpBean;

import java.util.List;

/**
 * Created by lenovo on 2017/10/8.
 */

public class MsRecycleAdapter extends RecyclerView.Adapter<MsRecycleAdapter.MyViewHolder> {
    private List<MiaoShaBean2> list;
    private Context context;;

    public MsRecycleAdapter(List<MiaoShaBean2> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.miaoshaitem,null);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_price1ms.setText(list.get(position).getPrice()+"");
        holder.tv_price2ms.setText(list.get(position).getBargainPrice()+"");
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder.iv_ms);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv_price1ms;
        private TextView tv_price2ms;
        private ImageView iv_ms;
        public MyViewHolder(View itemView) {
           super(itemView);
            iv_ms= itemView.findViewById(R.id.iv_ms);
            tv_price1ms= itemView.findViewById(R.id.tv_price1ms);
            tv_price2ms= itemView.findViewById(R.id.tv_price2ms);
        }
    }
}
