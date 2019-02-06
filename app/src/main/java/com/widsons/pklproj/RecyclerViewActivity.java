package com.widsons.pklproj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.widsons.pklproj.custom.SwitchCustomView;

/**
 * Created on : January/22/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class RecyclerViewActivity extends AppCompatActivity {


    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        SwitchCustomView switchCustomView = findViewById(R.id.switch_custom_view);
        switchCustomView.setOnChangeListener(new SwitchCustomView.OnChangeListener() {
            @Override
            public void onChange(boolean isChecked) {
                Toast.makeText(RecyclerViewActivity.this, "is checked " + isChecked, Toast.LENGTH_LONG).show();
            }
        });
//        RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
//        recyclerView.addOnItemTouchListener(new OnItemClickRecyclerView(this){
//
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//        });
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }
}
