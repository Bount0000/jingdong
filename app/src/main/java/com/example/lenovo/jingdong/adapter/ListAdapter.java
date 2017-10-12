package com.example.lenovo.jingdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.bean.BigFenlei2;
import com.example.lenovo.jingdong.fragment.Fragment_fenlei;

import java.util.List;

/**
 * Created by lenovo on 2017/10/10.
 */

public class ListAdapter extends BaseAdapter{
    private Context context;
    private List<BigFenlei2> list;

    public ListAdapter(Context context, List<BigFenlei2> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         view=View.inflate(context, R.layout.listitem,null);
         TextView tv_name= view.findViewById(R.id.tv_name);
         tv_name.setText(list.get(i).getName());
        if(i== Fragment_fenlei.currentpostion)
        {
            tv_name.setTextColor(context.getResources().getColor(R.color.red));
        }
        else
        {
            tv_name.setTextColor(context.getResources().getColor(R.color.black));
        }
        return view;
    }
}
