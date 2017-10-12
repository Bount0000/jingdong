package com.example.lenovo.jingdong.bean;

/**
 * Created by lenovo on 2017/10/11.
 */

public class SmallBean {

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

    @Override
    public String toString() {
        return "SmallBean{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public SmallBean() {

    }

    public SmallBean(String name, String icon) {

        this.name = name;
        this.icon = icon;
    }
}
