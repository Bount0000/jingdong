package com.example.lenovo.jingdong;

import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.lenovo.jingdong.fragment.Fragment_faxian;
import com.example.lenovo.jingdong.fragment.Fragment_fenlei;
import com.example.lenovo.jingdong.fragment.Fragment_gouwuche;
import com.example.lenovo.jingdong.fragment.Fragment_wode;
import com.example.lenovo.jingdong.fragment.Fragment_youye;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout lt_faxian;
    private LinearLayout lt_youye;
    private LinearLayout lt_fenlei;
    private LinearLayout lt_gouwuche;
    private LinearLayout lt_wode;
    private FrameLayout fl;
    private Fragment_youye fragment_youye;
    private Fragment_faxian fragment_faxian;
    private Fragment_fenlei fragment_fenlei;
    private Fragment_gouwuche fragment_gouwuche;
    private Fragment_wode fragment_wode;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private RadioButton btn_1;
    private RadioButton btn_2;
    private RadioButton btn_3;
    private RadioButton btn_4;
    private RadioButton btn_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         initView();
         initDate();
    }

    private void initDate() {
        fragment_youye = new Fragment_youye();
        fragment_faxian = new Fragment_faxian();
        fragment_fenlei = new Fragment_fenlei();
        fragment_gouwuche = new Fragment_gouwuche();
        fragment_wode = new Fragment_wode();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,fragment_youye).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,fragment_faxian).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,fragment_fenlei).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,fragment_gouwuche).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,fragment_wode).commit();

        getSupportFragmentManager().beginTransaction().show(fragment_youye).commit();
        getSupportFragmentManager().beginTransaction().hide(fragment_faxian).commit();
        getSupportFragmentManager().beginTransaction().hide(fragment_fenlei).commit();
        getSupportFragmentManager().beginTransaction().hide(fragment_gouwuche).commit();
        getSupportFragmentManager().beginTransaction().hide(fragment_wode).commit();
        iv1.setImageResource(R.mipmap.shouye2);
        iv2.setImageResource(R.mipmap.fenlei1);
        iv3.setImageResource(R.mipmap.faxian1);
        iv4.setImageResource(R.mipmap.gouwuche1);
        iv5.setImageResource(R.mipmap.wode1);
        btn_1.setTextColor(Color.RED);
        btn_2.setTextColor(Color.BLACK);
        btn_3.setTextColor(Color.BLACK);
        btn_4.setTextColor(Color.BLACK);
        btn_5.setTextColor(Color.BLACK);
    }
    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        lt_faxian = (LinearLayout) findViewById(R.id.lt_faxian);
        lt_youye = (LinearLayout) findViewById(R.id.lt_youye);
        lt_fenlei = (LinearLayout) findViewById(R.id.lt_fenlei);
        lt_gouwuche = (LinearLayout) findViewById(R.id.lt_gouwuche);
        lt_wode = (LinearLayout) findViewById(R.id.lt_wode);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        iv5 = (ImageView) findViewById(R.id.iv5);

        btn_1 = (RadioButton) findViewById(R.id.btn_1);
        btn_2 = (RadioButton) findViewById(R.id.btn_2);
        btn_3 = (RadioButton) findViewById(R.id.btn_3);
        btn_4 = (RadioButton) findViewById(R.id.btn_4);
        btn_5 = (RadioButton) findViewById(R.id.btn_5);

        lt_youye.setOnClickListener(this);
        lt_faxian.setOnClickListener(this);
        lt_fenlei.setOnClickListener(this);
        lt_gouwuche.setOnClickListener(this);
        lt_wode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.lt_youye:
                getSupportFragmentManager().beginTransaction().show(fragment_youye).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_faxian).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_fenlei).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_gouwuche).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_wode).commit();
                iv1.setImageResource(R.mipmap.shouye2);
                iv2.setImageResource(R.mipmap.fenlei1);
                iv3.setImageResource(R.mipmap.faxian1);
                iv4.setImageResource(R.mipmap.gouwuche1);
                iv5.setImageResource(R.mipmap.wode1);
                btn_1.setTextColor(Color.RED);
                btn_2.setTextColor(Color.BLACK);
                btn_3.setTextColor(Color.BLACK);
                btn_4.setTextColor(Color.BLACK);
                btn_5.setTextColor(Color.BLACK);
                break;
             case R.id.lt_fenlei:
                getSupportFragmentManager().beginTransaction().show(fragment_fenlei).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_youye).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_faxian).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_gouwuche).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_wode).commit();
                iv1.setImageResource(R.mipmap.fenlei1);
                iv2.setImageResource(R.mipmap.shouye2);
                iv3.setImageResource(R.mipmap.faxian1);
                iv4.setImageResource(R.mipmap.gouwuche1);
                iv5.setImageResource(R.mipmap.wode1);
                 btn_1.setTextColor(Color.BLACK);
                 btn_2.setTextColor(Color.RED);
                 btn_3.setTextColor(Color.BLACK);
                 btn_4.setTextColor(Color.BLACK);
                 btn_5.setTextColor(Color.BLACK);

                break;

            case R.id.lt_faxian:
                getSupportFragmentManager().beginTransaction().show(fragment_faxian).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_youye).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_fenlei).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_gouwuche).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_wode).commit();

                iv1.setImageResource(R.mipmap.fenlei1);
                iv2.setImageResource(R.mipmap.shouye1);
                iv3.setImageResource(R.mipmap.faxian2);
                iv4.setImageResource(R.mipmap.gouwuche1);
                iv5.setImageResource(R.mipmap.wode1);

                btn_1.setTextColor(Color.BLACK);
                btn_2.setTextColor(Color.BLACK);
                btn_3.setTextColor(Color.RED);
                btn_4.setTextColor(Color.BLACK);
                btn_5.setTextColor(Color.BLACK);
                break;

            case R.id.lt_gouwuche:
                getSupportFragmentManager().beginTransaction().show(fragment_gouwuche).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_faxian).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_fenlei).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_youye).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_wode).commit();
                iv1.setImageResource(R.mipmap.fenlei1);
                iv2.setImageResource(R.mipmap.shouye1);
                iv3.setImageResource(R.mipmap.faxian1);
                iv4.setImageResource(R.mipmap.gouwuche2);
                iv5.setImageResource(R.mipmap.wode1);

                btn_1.setTextColor(Color.BLACK);
                btn_2.setTextColor(Color.BLACK);
                btn_3.setTextColor(Color.BLACK);
                btn_4.setTextColor(Color.RED);
                btn_5.setTextColor(Color.BLACK);
                break;

            case R.id.lt_wode:
                getSupportFragmentManager().beginTransaction().show(fragment_wode).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_faxian).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_fenlei).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_gouwuche).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment_youye).commit();
                iv1.setImageResource(R.mipmap.shouye1);
                iv2.setImageResource(R.mipmap.fenlei1);
                iv3.setImageResource(R.mipmap.faxian1);
                iv4.setImageResource(R.mipmap.gouwuche1);
                iv5.setImageResource(R.mipmap.wode2);

                btn_1.setTextColor(Color.BLACK);
                btn_2.setTextColor(Color.BLACK);
                btn_3.setTextColor(Color.BLACK);
                btn_4.setTextColor(Color.BLACK);
                btn_5.setTextColor(Color.RED);
                break;
        }
    }
}
