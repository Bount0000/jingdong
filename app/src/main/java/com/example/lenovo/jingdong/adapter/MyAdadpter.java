package com.example.lenovo.jingdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.jingdong.MainActivity;
import com.example.lenovo.jingdong.R;
import com.example.lenovo.jingdong.bean.Fenlei;

import java.util.List;

/**
 * Created by lenovo on 2017/9/29.
 */

public class MyAdadpter extends BaseAdapter {
    private Context context;
    private List<Fenlei> list;
   private static int mpostion;
    public MyAdadpter(Context context, List<Fenlei> list) {
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=View.inflate(context, R.layout.list_view,null);
        TextView tv=view.findViewById(R.id.tv);
        mpostion=i;
        tv.setText(list.get(i).getName());
        /*if(i==mpostion)
        {
            view.setBackgroundResource();
        }*/
        return view;
    }
}
