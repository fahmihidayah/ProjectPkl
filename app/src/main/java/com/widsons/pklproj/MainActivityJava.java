package com.widsons.pklproj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created on : December/13/2018
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User();
         ListView listView = findViewById(R.id.list_view);
        // ------
        ArrayList<User> namas = new ArrayList<>();


        ArrayAdapter<User> adapterString = new ArrayAdapterCustom(this, -1, namas);
        // ------
        listView.setAdapter(adapterString);

    }
}
