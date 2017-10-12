package com.example.lenovo.jingdong.presenter;


import android.text.TextUtils;

import com.example.lenovo.jingdong.bean.LoginBean;
import com.example.lenovo.jingdong.model.Loginmodel;
import com.example.lenovo.jingdong.view.Loginview;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by lenovo on 2017/10/9.
 */

public class Loginpresenter implements Loginmodel.ILogin {
   private Loginmodel loginmodel;
    private Loginview loginview;

    public Loginpresenter(Loginview loginview) {
        this.loginview = loginview;
        loginmodel=new Loginmodel();
        loginmodel.setiLogin(this);
    }
    public void login(String mobile,String psd)
    {
        if(TextUtils.isEmpty(mobile))
        {
            loginview.moblieError("手机号不能为空");
            return;
        }

        if(TextUtils.isEmpty(psd))
        {
            loginview.moblieError("密码不能为空");
             return;
        }
        loginmodel.login(mobile,psd);
    }
    public void register(String mobile,String psd)
    {
        loginview.hideProgress();
        if(TextUtils.isEmpty(mobile))
        {
            loginview.moblieError("手机号不能为空");
            return;
        }

        if(TextUtils.isEmpty(psd))
        {
            loginview.moblieError("密码不能为空");
            return;
        }
        loginmodel.register(mobile,psd);
    }
    @Override
    public void loginSuccess(String code, String msg,LoginBean userbean) {
        loginview.hideProgress();
        loginview.loginSuccess(code,msg,userbean);
    }

    @Override
    public void loginFail(String code, String msg) {
        loginview.hideProgress();
        loginview.loginError(code,msg);
    }
    @Override
    public void onFailure(Call call, IOException e) {
        loginview.hideProgress();
        loginview.onFailure(call,e);
    }
}
