package com.example.lenovo.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.bean.Bean;
import com.example.lenovo.jingdong.bean.TuijianBean2;

import java.util.List;

/**
 * Created by lenovo on 2017/10/8.
 */

public class RecycleAdapter2 extends RecyclerView.Adapter<RecycleAdapter2.MyViewHolder> {
     private Context context;
    private List<TuijianBean2> list;

    public RecycleAdapter2(Context context, List<TuijianBean2> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.tuijianitem,null);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_price.setText(list.get(position).getPrice()+"");
        holder.tv_title.setText(list.get(position).getTitle());
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder.iv_icon);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

      class MyViewHolder extends RecyclerView.ViewHolder {
          private  TextView tv_title;
          private  TextView tv_price;
          private ImageView iv_icon;

          public MyViewHolder(View itemView) {
          super(itemView);
            tv_title= itemView.findViewById(R.id.tv_title);
            tv_price= itemView.findViewById(R.id.tv_price);
           iv_icon = itemView.findViewById(R.id.iv_icon);
      }
  }

}
