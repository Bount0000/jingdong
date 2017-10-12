package com.example.lenovo.jingdong.bean;

/**
 * Created by lenovo on 2017/10/10.
 */

public class VpBean {
    private String name;
    private String icon;

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

    public VpBean() {

    }

    public VpBean(String name, String icon) {

        this.name = name;
        this.icon = icon;
    }
}
