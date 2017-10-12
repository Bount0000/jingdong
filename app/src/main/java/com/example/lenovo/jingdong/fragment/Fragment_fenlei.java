package com.example.lenovo.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.support.v4.app.FragmentTransaction;
import android.widget.ListView;
import android.widget.TableLayout;

import com.example.lenovo.jingdong.Api;
import com.example.lenovo.jingdong.MainActivity;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.adapter.ListAdapter;
import com.example.lenovo.jingdong.adapter.MyAdadpter;
import com.example.lenovo.jingdong.adapter.VpAdapter;
import com.example.lenovo.jingdong.bean.BigFenlei;
import com.example.lenovo.jingdong.bean.BigFenlei2;
import com.example.lenovo.jingdong.bean.Fenlei;
import com.example.lenovo.jingdong.bean.FenleiBean;
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
 * Created by lenovo on 2017/9/29.
 */

public class Fragment_fenlei extends Fragment  {
    private String string;
    private List<Fenlei> list;
    private FrameLayout fl;
    private TableLayout tab;
    private ViewPager vp;
    private ListView lv;
    private String name;
    private int cid;
    private ListAdapter adapter;
    public static int mPosition;
    public static int currentpostion;//点击改变颜色的变量
    private List<BigFenlei2> list2;
    private MyFragment myFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(),R.layout.fenlei,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initDate();
        initShuzhi();
    }
    private void initShuzhi() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    currentpostion=i;
                    mPosition=i;
                    adapter.notifyDataSetChanged();
                    myFragment = new MyFragment();
                    Bundle budle=new Bundle();
                    budle.putInt(myFragment.TAG,list2.get(i).getCid());
                    myFragment.setArguments(budle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.flayout, myFragment).commit();
            }
        });
    }

    private void initDate() {
        OkHttpClient okhttp=new OkHttpClient();
        Request reauest=new Request.Builder().get().url(Api.feilei_URl).build();
         okhttp.newCall(reauest).enqueue(new Callback() {

             @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 if(response!=null&&response.isSuccessful())
                 {
                     string = response.body().string();
                     Jiexi();
                 }
            }

         });

    }
    private void Jiexi() {
        list2 = new ArrayList<>();
        Gson gson=new Gson();
        FenleiBean fenleiBean = gson.fromJson(string, FenleiBean.class);
        List<FenleiBean.DataBean> data = fenleiBean.getData();
        for (int i = 0; i <data.size() ; i++) {
            FenleiBean.DataBean dataBean = data.get(i);
            cid = dataBean.getCid();
            String name = dataBean.getName();
            list2.add(new BigFenlei2(cid,name));
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setDate();
            }
            private void setDate() {
            adapter = new ListAdapter(getContext(), list2);
            lv.setAdapter(adapter);
            }
        });
    }
    private void initView() {
        lv = getView().findViewById(R.id.lv);
        fl = getView().findViewById(R.id.flayout);
    }
}
