package com.widsons.pklproj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created on : December/13/2018
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class AdapterText extends ArrayAdapter<Integer> {
    public AdapterText(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);
    }

    public AdapterText(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Integer> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
