package com.example.lenovo.jingdong.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bumptech.glide.Glide;
import com.example.lenovo.jingdong.Api;
import com.example.lenovo.jingdong.MainActivity;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.SaoyisaoActivity;
import com.example.lenovo.jingdong.adapter.MsRecycleAdapter;
import com.example.lenovo.jingdong.adapter.RecycleAdapter;
import com.example.lenovo.jingdong.adapter.RecycleAdapter2;
import com.example.lenovo.jingdong.adapter.VpAdapter;
import com.example.lenovo.jingdong.bean.Bean;
import com.example.lenovo.jingdong.bean.FenleiBean;
import com.example.lenovo.jingdong.bean.MiaoShaBean2;
import com.example.lenovo.jingdong.bean.TuijianBean2;
import com.github.nuptboyzhb.lib.SuperSwipeRefreshLayout;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

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

public class Fragment_youye extends Fragment implements View.OnClickListener {

    private String icon;
    private View view;
    private XBanner xBanner;
    private List<String> list;
    private List<String> title2;
    private ImageView iv_sao;
    private ViewPager vp;
    private RecyclerView tjrv2;
    private List<TuijianBean2> tuijianlist;
    private RecyclerView rv_miaocha;
    private List<MiaoShaBean2> miaochalist;
    private SuperSwipeRefreshLayout superlayout;
    private ScrollView scrollview;
    private View view2;
   private int mDistanceY=0;
    private View toorbar_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(),R.layout.youye,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         initView();
         initDate();
        list = new ArrayList<String>();
        title2 = new ArrayList<String>();
        title2.add("这是一");
        title2.add("这是二");
        title2.add("这是三");
        title2.add("这是四");
        xBanner.setPageTransformer(Transformer.Default);
        xBanner.setPageChangeDuration(1000);
    }
    private void initDate() {
        OkHttpClient okhttp=new OkHttpClient();
        Request reauest=new Request.Builder().get().url(Api.VP_URl).build();
        Call call = okhttp.newCall(reauest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                jiexi(string);
            }
             private void jiexi(String string) {
                Gson gson=new Gson();
                Bean bean = gson.fromJson(string,Bean.class);
                List<Bean.DataBean> data = bean.getData();
                for (int i = 0; i <data.size(); i++) {
                    Bean.DataBean dataBean = data.get(i);
                    icon = dataBean.getIcon();
                    list.add(Fragment_youye.this.icon);
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setDate();
                    }
                });
            }
            private void setDate() {
                xBanner.setData(list,title2);
                xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, View view, int position) {
                        Glide.with(getContext()).load(list.get(position)).into((ImageView) view);
                    }
                });
            }
        });
        initaviewPager();
        initMiaosha();
        initTuijian();
    }
    private void initMiaosha() {
        miaochalist = new ArrayList<MiaoShaBean2>();
        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request=new Request.Builder().get().url(Api.VP_URl).build();
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
                    Bean bean = gson.fromJson(s, Bean.class);
                    Bean.MiaoshaBean miaosha = bean.getMiaosha();
                    List<Bean.MiaoshaBean.ListBeanX> list = miaosha.getList();
                    for (int i = 0; i <list.size() ; i++) {
                        Bean.MiaoshaBean.ListBeanX listBeanX = list.get(i);
                        double bargainPrice = listBeanX.getBargainPrice();
                        double price = listBeanX.getPrice();
                        String images = listBeanX.getImages();
                        String detailUrl = listBeanX.getDetailUrl();
                        miaochalist.add(new MiaoShaBean2(bargainPrice,price,images));
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           LinearLayoutManager listLayoutManager=new LinearLayoutManager(getContext());
                            listLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            rv_miaocha.setLayoutManager(listLayoutManager);
                            MsRecycleAdapter adapter=new MsRecycleAdapter(miaochalist,getContext());
                            rv_miaocha.setAdapter(adapter);
                        }
                    });
                }
            }
        });

    }

    private void initaviewPager() {
        List<Fragment> fragments=new ArrayList<Fragment>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        VpAdapter vpAdapter=new VpAdapter(getFragmentManager(),getContext(),fragments);
        vp.setAdapter(vpAdapter);
    }
   /* //当Activity失去焦点时立即停止自动轮播；当Activity获得焦点时才开始自动轮播
    @Override
    public void onResume() {
        super.onResume();
        xBanner.startAuztoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        xBanner.stopAutoPlay();
    }*/
    /**
     * 为你推荐接口
     */
    private void initTuijian() {
        tuijianlist = new ArrayList<>();
        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request=new Request.Builder().get().url(Api.VP_URl).build();
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
                    Bean bean = gson.fromJson(s, Bean.class);
                    Bean.TuijianBean tuijian = bean.getTuijian();
                    final List<Bean.TuijianBean.ListBean> list = tuijian.getList();
                    for (int i = 0; i <list.size() ; i++) {
                        Bean.TuijianBean.ListBean listBean = list.get(i);
                        double price = listBean.getPrice();
                        String detailUrl = listBean.getDetailUrl();
                        String images = listBean.getImages();
                        String title = listBean.getTitle();
                        String createtime = listBean.getCreatetime();
                        tuijianlist.add(new TuijianBean2(price,detailUrl,images,title));
                    }
                       getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
                            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                            tjrv2.setLayoutManager(gridLayoutManager);
                            RecycleAdapter2 adapter=new RecycleAdapter2(getContext(),tuijianlist);

                            RecyclerViewHeader recyclerViewHeader=new RecyclerViewHeader(getContext());
                            recyclerViewHeader.attachTo(tjrv2);
                            recyclerViewHeader.addView(view2);
                            tjrv2.setAdapter(adapter);


                        }
                    });
                }
            }
        });

        tjrv2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                int toolbarHeight = toorbar_layout.getBottom();

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    toorbar_layout.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                } else {
                    //将标题栏的颜色设置为完全不透明状态
                    toorbar_layout.setBackgroundResource(R.color.white);
                }
            }
        });
        superlayout.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener(){

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        superlayout.setRefreshing(false);
                    }
                }, 500);
            }

            @Override
            public void onPullDistance(int distance) {
                if (distance > 0) {
                    toorbar_layout.setVisibility(View.GONE);
                } else {
                    toorbar_layout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPullEnable(boolean b) {

            }
        });
    }
    private void initView() {
        view2 = View.inflate(getContext(), R.layout.youyehead_layout,null);
        toorbar_layout = View.inflate(getContext(), R.layout.toorbar_layout,null);
        xBanner = view2.findViewById(R.id.xbanner);
        iv_sao = toorbar_layout.findViewById(R.id.iv_sao);
        vp = view2.findViewById(R.id.vp);
        superlayout = view.findViewById(R.id.superlayout);
        tjrv2 = view.findViewById(R.id.tjrv2);
        rv_miaocha = view2.findViewById(R.id.rv_miaocha);
        iv_sao.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
     switch (view.getId())
     {
         case R.id.iv_sao:
             Intent intent=new Intent(getContext(),SaoyisaoActivity.class);
             startActivity(intent);
             break;
     }
    }
}
