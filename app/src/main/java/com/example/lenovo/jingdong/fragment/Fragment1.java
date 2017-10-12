package com.example.lenovo.jingdong.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.jingdong.Api;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.adapter.RecycleAdapter;
import com.example.lenovo.jingdong.bean.FenleiBean;
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

public class Fragment1 extends Fragment {

    private RecyclerView rv1;
    private List<VpBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.recycler1_layout,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),5);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv1.setLayoutManager(gridLayoutManager);
        initDate();
    }
    private void initDate() {
        list = new ArrayList<>();
        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request=new Request.Builder().get().url(Api.feilei_URl).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response!=null&&response.isSuccessful())
                {
                    String s = response.body().string();
                    Gson gson=new Gson();
                    FenleiBean fenleiBean = gson.fromJson(s, FenleiBean.class);
                    List<FenleiBean.DataBean> data = fenleiBean.getData();
                    for (int i = 0; i<10; i++) {
                        FenleiBean.DataBean dataBean = data.get(i);
                        String name = dataBean.getName();
                        String icon = dataBean.getIcon();
                        String ishome = dataBean.getIshome();
                        list.add(new VpBean(name,icon));
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RecycleAdapter adapter=new RecycleAdapter(list,getActivity());
                            rv1.setAdapter(adapter);
                        }
                    });
                }
            }
        });

    }
    private void initview() {
        rv1 = getView().findViewById(R.id.rv1);
    }
}
