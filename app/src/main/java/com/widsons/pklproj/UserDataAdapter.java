package com.widsons.pklproj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.widsons.pklproj.model.UserData;

import java.util.List;

/**
 * Created on : January/11/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class UserDataAdapter extends ArrayAdapter<UserData> {


    public UserDataAdapter(@NonNull Context context, int resource, @NonNull List<UserData> objects) {
        super(context, resource, objects);
    }
}
