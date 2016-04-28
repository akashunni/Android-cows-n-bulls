package com.example.akash.cowsnbulls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by akash on 19/9/15.
 */
public class List_Adapter extends BaseAdapter {
    ArrayList<Information> info;
    LayoutInflater layoutInflater;
    List_Adapter(Context con,ArrayList<Information> info){
        this.info = info;
        layoutInflater = LayoutInflater.from(con);
    }
    @Override
    public int getCount() {
        return info.size();
    }

    @Override
    public Object getItem(int position) {
        return info.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View_list vl;
        if(convertView==null){
            vl = new View_list();
            convertView = layoutInflater.inflate(R.layout.list_view,parent,false);
            vl.chance_text = (TextView) convertView.findViewById(R.id.chance_text);
            vl.cows_text = (TextView) convertView.findViewById(R.id.cows_text);
            vl.bulls_text = (TextView) convertView.findViewById(R.id.bulls_text);
            vl.guess_text = (TextView) convertView.findViewById(R.id.guess_text);
            convertView.setTag(vl);
        }
        else {
            vl = (View_list) convertView.getTag();
        }
        vl.chance_text.setText(info.get(position).getChance_info()+"");
        vl.cows_text.setText(info.get(position).getCows_info()+"");
        vl.bulls_text.setText(info.get(position).getBulls_info()+"");
        vl.guess_text.setText(info.get(position).getAnswer()+"");
        return convertView;
    }
}
class View_list{
    TextView chance_text;
    TextView cows_text;
    TextView bulls_text;
    TextView guess_text;
}
