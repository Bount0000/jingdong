package com.example.lenovo.jingdong.model;

import com.example.lenovo.jingdong.Api;
import com.example.lenovo.jingdong.bean.LoginBean;
import com.example.lenovo.jingdong.bean.ZhuceBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/10/9.
 */
public class Loginmodel {
    private LoginBean userbean;
    public String TAg="Loginmodel";
    private String msg;
    private String code;
    private String mobilename;
    private String icon;
    //登录信息
    public void login(final String mobile, final String psd)
    {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder=new FormBody.Builder();
        builder.add("mobile",mobile);
        builder.add("password",psd);
        FormBody body=builder.build();
        final Request request=new Request.Builder().post(body).url(Api.LOGIN).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new okhttp3.Callback() {



            @Override
            public void onFailure(Call call, IOException e) {
                iLogin.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if(response!=null&&response.isSuccessful())
                {
                    String s = response.body().string();
                    Jiexi(s);
                    if(code.equals("0"))
                    {
                        iLogin.loginSuccess(code,"登录成功",userbean);
                        System.out.println(s);
                    }
                    else
                    {
                        iLogin.loginFail(code,"登录失败");
                    }
                }
            }
            private void Jiexi(String s) {
                Gson gson=new  Gson();
                LoginBean loginBean = gson.fromJson(s, LoginBean.class);
                LoginBean.DataBean data = loginBean.getData();
                msg = loginBean.getMsg();
                code = loginBean.getCode();
               // icon = data.getIcon();
                //Log.e(TAg,"----------------"+icon);
                mobilename = data.getMobile();
            }
        });
    }
    //注册信息
    public void register(final String mobile, final String psd)
    {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder=new FormBody.Builder();
        builder.add("mobile",mobile);
        builder.add("password",psd);
        FormBody body=builder.build();
        final Request request=new Request.Builder().post(body).url(Api.zhuce).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iLogin.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if(response!=null&&response.isSuccessful())
                {
                    String s = response.body().string();
                    Jiexi(s);
                    if(code.equals("0"))
                    {
                        iLogin.loginSuccess(code,"登录成功",userbean);
                    }
                    else
                    {
                        iLogin.loginFail(code,"登录失败");
                    }

                }

            }

            private void Jiexi(String s) {
                Gson gson=new  Gson();
                ZhuceBean zhuceBean = gson.fromJson(s, ZhuceBean.class);
                msg = zhuceBean.getMsg();
                code = zhuceBean.getCode();
            }
        });
    }

    //上传头像信息
    public void change(final String mobile, final String psd)
    {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder=new FormBody.Builder();
        builder.add("mobile",mobile);
        builder.add("password",psd);
        FormBody body=builder.build();
        final Request request=new Request.Builder().post(body).url(Api.relepace).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new okhttp3.Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                iLogin.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if(response!=null&&response.isSuccessful())
                {
                    String s = response.body().string();
                    Jiexi(s);
                    if(code.equals("0"))
                    {
                        iLogin.loginSuccess(code,"登录成功",userbean);
                    }
                    else
                    {
                        iLogin.loginFail(code,"登录失败");
                    }

                }

            }

            private void Jiexi(String s) {
                Gson gson=new  Gson();
                userbean = gson.fromJson(s, LoginBean.class);
                LoginBean.DataBean data = userbean.getData();
                msg = userbean.getMsg();
                code = userbean.getCode();
            }
        });
    }
    private ILogin iLogin;

    public void setiLogin(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    public interface ILogin
    {
        void loginSuccess(String code, String msg,LoginBean userbean);
        void loginFail(String code, String msg);
        void onFailure(Call call, IOException e);
    }





}
