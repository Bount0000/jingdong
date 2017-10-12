package com.example.lenovo.jingdong.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lenovo.jingdong.bean.Fenlei;

import java.util.List;

/**
 * Created by lenovo on 2017/10/8.
 */

public class VpAdapter extends FragmentPagerAdapter {
private Context context;
private List<Fragment> fragments;

    public VpAdapter(FragmentManager fm) {
        super(fm);
    }

    public VpAdapter(FragmentManager fm,Context context,List<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
