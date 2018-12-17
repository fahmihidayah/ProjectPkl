package com.widsons.pklproj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created on : December/13/2018
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class AdapterString extends BaseAdapter {

    private ArrayList<String> dataString = new ArrayList<>();

    public void setDataString(ArrayList<String> dataString) {
        this.dataString = dataString;
    }

    @Override
    public int getCount() {
        return dataString.size();
    }

    @Override
    public Object getItem(int position) {
        return dataString.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, parent, false);
        return viewHolder;
    }
}
