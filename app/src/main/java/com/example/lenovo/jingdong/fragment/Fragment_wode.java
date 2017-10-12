package com.example.lenovo.jingdong.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.jingdong.LoginActivity;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.UserActivity;

/**
 * Created by lenovo on 2017/9/29.
 */

public class Fragment_wode extends Fragment implements View.OnClickListener {

    private TextView tv_login;
    private TextView tv_zhuce;
    private ImageView iv_icon;
    private TextView tv_mobilename;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(),R.layout.wode,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initDate();
    }
    private void initDate() {
       // Bundle bundle = getArguments();
        //Toast.makeText(getContext(), "----"+bundle, Toast.LENGTH_SHORT).show();
      /* //String icon = bundle.getString("icon");
        String mobilename = bundle.getString("mobilename");
        if(mobilename!=null)
        {
            tv_mobilename.setText(mobilename);
        }*/
       // Glide.with(getContext()).load(icon).into(iv_icon);
         SharedPreferences sp= getActivity().getSharedPreferences("phnoename", Context.MODE_PRIVATE);
         String mobilename = sp.getString("mobilename", "");
        if(mobilename!=null)
        {
            tv_mobilename.setText(mobilename);
        }
    }

    private void initView(){
        tv_login = getView().findViewById(R.id.tv_login);
        tv_zhuce = getView().findViewById(R.id.tv_zhuce);
        iv_icon = getView().findViewById(R.id.iv_icon);
        tv_mobilename = getView().findViewById(R.id.tv_mobilename);
        tv_login.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tv_mobilename:
               Intent intent2=new Intent(getContext(),UserActivity.class);
                startActivity(intent2);
                break;
            case R.id.tv_zhuce:
                break;
            case R.id.tv_login:
                Intent intent=new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
