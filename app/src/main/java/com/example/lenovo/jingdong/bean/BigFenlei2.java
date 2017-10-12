package com.example.lenovo.jingdong.bean;

import android.graphics.Paint;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lenovo on 2017/10/10.
 */

public class BigFenlei2 {

   private   int cid;
    private String name;

    @Override
    public String toString() {
        return "BigFenlei2{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigFenlei2() {

    }

    public BigFenlei2(int cid, String name) {

        this.cid = cid;
        this.name = name;
    }
}
