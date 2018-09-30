package com.example.user.a0911_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class CommunityAdapter extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<CommuInfor> data = null;
    private LayoutInflater inflater = null;

    public CommunityAdapter(Context c, int l, ArrayList<CommuInfor> d) {
        this.mContext = c;
        this.layout = l;
        this.data = d;
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        ImageView Co_image = (ImageView) convertView.findViewById(R.id.Commu_image);
        TextView Co_name = (TextView) convertView.findViewById(R.id.Commu_name);
        TextView Co_text = (TextView) convertView.findViewById(R.id.Commu_text);


        Co_image.setImageBitmap(data.get(position).c_image);
        Co_name.setText(data.get(position).c_name);
        Co_text.setText(data.get(position).c_text);

        return convertView;
    }
}

