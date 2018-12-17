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
        ListView listView = findViewById(R.id.list_view);
        // ------
        ArrayList<String> namas = new ArrayList<>();
        namas.add("fahmi");
        namas.add("doni");
        namas.add("wildan");

        ArrayAdapter<String> arrayAdapters = new ArrayAdapter<String>(this, R.layout.item_string, R.id.text_nama, namas);
        ArrayAdapter<String> adapterString = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, namas);
        // ------
        listView.setAdapter(adapterString);

    }
}
