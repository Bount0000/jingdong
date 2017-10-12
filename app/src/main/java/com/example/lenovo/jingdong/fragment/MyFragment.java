package com.example.lenovo.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.adapter.BigRecycleAdapter;
import com.example.lenovo.jingdong.bean.BigBean;
import com.example.lenovo.jingdong.bean.BigFenlei;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.id.list;

/**
 * Created by lenovo on 2017/10/10.
 */

public class MyFragment extends Fragment
{

    public static final String TAG = "MyFragment";
    private int cid;
    private RecyclerView ryview;
    private List<BigBean> list2;
    private String name;
    private TextView tv_title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(),R.layout.myfragment, null);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initDate();
    }
    private void initDate() {
        //得到数据
        cid = getArguments().getInt(TAG);
       // tv_title.setText(cid+"");
        list2 = new ArrayList<>();
        OkHttpClient okhttp=new OkHttpClient();
        Request request=new Request.Builder().get().url("http://120.27.23.105/product/getProductCatagory?cid="+cid).build();
        okhttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
              if(response!=null&&response.isSuccessful())
              {
                  String string = response.body().string();
                  System.out.println(string);
                  Jiexi(string);
              }
            }
        });
    }

    private void Jiexi(String string){
        Gson gson=new Gson();
        BigFenlei bigFenlei = gson.fromJson(string,BigFenlei.class);
        List<BigFenlei.DataBean> data = bigFenlei.data;
        for (int i = 0; i < data.size() ; i++) {
            BigFenlei.DataBean dataBean = data.get(i);
             name = dataBean.name;
            List<BigFenlei.DataBean.ListBean> list = dataBean.list;
            list2.add(new BigBean(name,list));
        }
        if(getActivity()!=null)
      {
          getActivity().runOnUiThread(new Runnable() {
              @Override
              public void run() {
                  setDate();
                 // Toast.makeText(getContext(),"---"+list.get(0), Toast.LENGTH_SHORT).show();
              }
          });
      }
    }
    private void setDate() {
        ryview.setLayoutManager(new LinearLayoutManager(getContext()));
        BigRecycleAdapter adapter=new BigRecycleAdapter(getContext(),list2);
        ryview.setAdapter(adapter);
        View view=View.inflate(getContext(),R.layout.zifeileihead_layout,null);
        RecyclerViewHeader recyclerViewHeader=new RecyclerViewHeader(getContext());
        recyclerViewHeader.attachTo(ryview);
        recyclerViewHeader.addView(view);
    }
    private void initView() {
        tv_title = (TextView) getView().findViewById(R.id.tv_title);
        ryview = getView().findViewById(R.id.ryview);
    }
}
