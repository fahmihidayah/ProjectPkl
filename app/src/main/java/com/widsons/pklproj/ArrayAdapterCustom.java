package com.widsons.pklproj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created on : December/17/2018
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class ArrayAdapterCustom extends ArrayAdapter<String> {

    public ArrayAdapterCustom(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        // 2.
        ContactViewHolder contactViewHolder = new ContactViewHolder();
        contactViewHolder.imageViewContact = view.findViewById(R.id.image_view_contact);
        contactViewHolder.textViewContactName = view.findViewById(R.id.text_view_contact_name);
        // 3.
        String data = getItem(position);
        // 4.
        contactViewHolder.textViewContactName.setText(data);
        if(position % 2 == 0) {
            contactViewHolder.imageViewContact.setImageResource(android.R.drawable.ic_menu_send);
        }
        else {
            contactViewHolder.imageViewContact.setImageResource(android.R.drawable.ic_menu_edit);
        }

        return view;
    }


}
