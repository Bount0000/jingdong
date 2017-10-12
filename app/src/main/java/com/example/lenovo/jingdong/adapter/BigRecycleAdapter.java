package com.example.lenovo.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bumptech.glide.Glide;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.bean.BigBean;
import com.example.lenovo.jingdong.bean.BigFenlei;
import com.example.lenovo.jingdong.bean.SmallBean;
import com.example.lenovo.jingdong.bean.VpBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/10/8.
 */

public class BigRecycleAdapter extends RecyclerView.Adapter<BigRecycleAdapter.MyViewHolder> {
    private List<BigBean> list;
    private Context context;;
    private List<SmallBean> smalllist;
    private RecyclerView rv_view;
    private String name;
    private String icon;

    public BigRecycleAdapter(Context context, List<BigBean> list) {
        this.list = list;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.fenleiitem1,null);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.t_name.setText(list.get(position).getName());
          smalllist=new ArrayList<SmallBean>();
        List<BigFenlei.DataBean.ListBean> list = this.list.get(position).getList();
        for (int i = 0; i <list.size() ; i++) {
            BigFenlei.DataBean.ListBean listBean = list.get(i);
            name = listBean.name;
            icon = listBean.icon;
            smalllist.add(new SmallBean(name,icon)) ;
        }
          setDate();
    }
    private void setDate() {
        SmallRvAdapter Adapter=new SmallRvAdapter(context,smalllist);
        rv_view.setAdapter(Adapter);
        GridLayoutManager linearLayoutManager=new GridLayoutManager(context,5);
        linearLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv_view.setLayoutManager(linearLayoutManager);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {   private TextView t_name;
        public MyViewHolder(View itemView) {
           super(itemView);
             t_name= itemView.findViewById(R.id.t_name);
             rv_view= itemView.findViewById(R.id.rv_view);
        }
    }
}
