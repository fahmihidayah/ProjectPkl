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
public class ArrayAdapterCustom extends ArrayAdapter<User> {

    public ArrayAdapterCustom(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1.
        ContactViewHolder contactViewHolder = null;

        if(convertView == null) {

            //
            // 2.

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
            // ini dihindari
            contactViewHolder = new ContactViewHolder();
            // ini dihindari
            contactViewHolder.imageViewContact = convertView.findViewById(R.id.image_view_contact);
            contactViewHolder.textViewContactName = convertView.findViewById(R.id.text_view_contact_name);
            convertView.setTag(contactViewHolder);

        }
        else {
            contactViewHolder = (ContactViewHolder) convertView.getTag();
        }
        // 3.
        User data = getItem(position);
        // 4.
        contactViewHolder.textViewContactName.setText(data.getNama());
        if(position % 2 == 0) {
            contactViewHolder.imageViewContact.setImageResource(data.getResImage());
        }
        else {
            contactViewHolder.imageViewContact.setImageResource(data.getResImage());
        }

        return convertView;
    }


}
