package com.example.lenovo.jingdong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class SaoyisaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saoyisao);
        IntentIntegrator integrator = new IntentIntegrator(SaoyisaoActivity.this);
       // 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setCaptureActivity(ScanActivity.class);
        integrator.setPrompt("请扫描"); //底部的提示文字，设为""可以置空
        integrator.setCameraId(0); //前置或者后置摄像头
        integrator.setBeepEnabled(false); //扫描成功的「哔哔」声，默认开启
        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if(result!=null)
        {
             if(result.getContents()==null)
             {
                 Toast.makeText(this, "扫码取消！", Toast.LENGTH_SHORT).show();
             }
             else
             {
                 Intent intent=new Intent(SaoyisaoActivity.this,XiangqingActivity.class);
                 intent.putExtra("url",result.getContents());
                 startActivity(intent);
             }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
