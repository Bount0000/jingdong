package com.example.lenovo.jingdong.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/10/11.
 */

public class BigBean {
    public String name;
    public List<BigFenlei.DataBean.ListBean>list;

    @Override
    public String toString() {
        return "BigBean{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BigFenlei.DataBean.ListBean> getList() {
        return list;
    }

    public void setList(List<BigFenlei.DataBean.ListBean> list) {
        this.list = list;
    }

    public BigBean() {

    }

    public BigBean(String name, List<BigFenlei.DataBean.ListBean> list) {

        this.name = name;
        this.list = list;
    }
}
