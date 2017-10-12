package com.example.lenovo.jingdong.view;

import com.example.lenovo.jingdong.bean.LoginBean;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by lenovo on 2017/10/9.
 */

public interface Loginview {
    void moblieError(String msg);
    void psdError(String msg);
    void showProgress();
    void hideProgress();

    void loginSuccess(String code, String msg,LoginBean userbean);
    void loginError(String code,String msg);
    void onFailure(Call call, IOException e);
}
