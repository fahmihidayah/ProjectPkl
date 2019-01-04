package com.widsons.pklproj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.widsons.pklproj.model.Siswa;
import com.widsons.pklproj.model.User;

import java.util.List;

/**
 * Created on : December/17/2018
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class ArrayAdapterCustom extends ArrayAdapter<Siswa> {

    private boolean isEditMode;

    public void setEditMode(boolean editMode) {
        isEditMode = editMode;
        notifyDataSetChanged();
    }

    public ArrayAdapterCustom(@NonNull Context context, int resource, @NonNull List<Siswa> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Siswa data = getItem(position);

        int type = data.getType();
        if(type == 1) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        }
        else {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
            TextView textViewNama = convertView.findViewById(R.id.text_view_contact_name);
            textViewNama.setText(data.getNama());
        }


        return convertView;
    }


}
