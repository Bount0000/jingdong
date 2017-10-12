package com.example.lenovo.jingdong;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.jingdong.bean.LoginBean;
import com.example.lenovo.jingdong.presenter.Loginpresenter;
import com.example.lenovo.jingdong.view.Loginview;

import java.io.IOException;

import okhttp3.Call;

public class LoginActivity extends AppCompatActivity implements Loginview,View.OnClickListener{
    private EditText et_phone;
    private EditText et_psd;
    private Button login;
    private Button register;
    private ProgressBar progerss;
    private Loginpresenter persenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initDate();
    }

    private void initDate() {
        persenter=new Loginpresenter(this);
    }

    private void initView() {
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_psd = (EditText) findViewById(R.id.et_psd);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        progerss = (ProgressBar) findViewById(R.id.progerss);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.login:
                persenter.login(et_phone.getText().toString(),et_psd.getText().toString());
                finish();
                break;
            case R.id.register:
              persenter.register(et_phone.getText().toString(),et_psd.getText().toString());
                break;
        }
    }
    @Override
    public void moblieError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void psdError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
     runOnUiThread(new Runnable() {
         @Override
         public void run() {
             progerss.setProgress(View.VISIBLE);
         }
     });
    }

    @Override
    public void hideProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progerss.setProgress(View.GONE);
            }
        });
    }

    @Override
    public void loginSuccess(String code, String msg, final LoginBean userbean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                LoginBean.DataBean data = userbean.getData();
                String mobilename = data.getMobile();
                SharedPreferences sp = getSharedPreferences("phnoename", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("mobilename", mobilename).commit();
                 Toast.makeText(LoginActivity.this, "---"+mobilename, Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*   @Override
          public void loginSucces(String code, String msg, LoginBean userbean) {
           runOnUiThread(new Runnable() {
               @Override
               public void run() {
                   Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                   SharedPreferences sp = getSharedPreferences("phnoename", MODE_PRIVATE);
                   SharedPreferences.Editor edit = sp.edit();
                  // edit.putString("mobilename", mobilename).commit();
                  *//* Fragment_wode wode=new Fragment_wode();
                Bundle bundle=new Bundle();
                bundle.putString("mobilename",mobilename);
                Toast.makeText(LoginActivity.this, "---"+icon, Toast.LENGTH_SHORT).show();
                wode.setArguments(bundle);*//*
              //  Toast.makeText(LoginActivity.this, "---"+mobilename, Toast.LENGTH_SHORT).show();
            }
        });
    }
*/
    @Override
    public void loginError(String code, String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFailure(Call call, IOException e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登录异常", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
