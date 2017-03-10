package com.example.viewholdertext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<PersonInfo> datas;

    public MyAdapter(Context context, List<PersonInfo> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas!=null?datas.size():0;
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_list,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textViewName.setText(getItem(position).toString());
        viewHolder.textViewAge.setText(datas.get(position).toString());


        return convertView;
    }
    public class ViewHolder{
        TextView textViewName;
        TextView textViewAge;
        public ViewHolder(View view) {
            textViewName= (TextView) view.findViewById(R.id.txt_name);
            textViewAge= (TextView) view.findViewById(R.id.txt_age);
        }
    }
}
