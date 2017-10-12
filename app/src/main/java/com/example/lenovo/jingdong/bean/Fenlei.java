package com.example.lenovo.jingdong.bean;

import android.support.v4.app.Fragment;

/**
 * Created by lenovo on 2017/9/29.
 */

public class Fenlei {
    private String name;
    private String icon;
   private Fragment fragment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fenlei(String name, String icon, Fragment fragment) {

        this.name = name;
        this.icon = icon;
        this.fragment = fragment;
    }

    @Override
    public String toString() {
        return "Fenlei{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", fragment=" + fragment +
                '}';
    }
}
