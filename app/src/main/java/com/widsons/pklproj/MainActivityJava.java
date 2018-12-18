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
    String [] emails = {"fahmi@gmail.com", "doni@gmail.com"};
    String [] phones = {"1231231525", "23434343"};
    String [] nama = {"fahmi", "34353"};

    int [] umur = {12};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ListView listView = findViewById(R.id.list_view);
        // ------
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("fahmi", "fahmi@gmail.com", "092309232"));
        users.add(new User("doni", "doni@gmail.com", "224756565"));
        User user = new User();

        user.setNama("abc");
        user.setPhone("123");
        user.setEmail("abc@gmail.com");
        users.add(user);

        user = new User();


//        for(int i = 0 ; i < emails.length; i++) {
//
//            User userBaru = new User(nama[i], emails[i], phones[i]);
//
////            userBaru.setEmail(emails[i]);
////            userBaru.setPhone(phones[i]);
////            userBaru.setNama(nama[i]);
//
//            users.add(userBaru);
//
//        }


        ArrayAdapter<User> adapterString = new ArrayAdapterCustom(this, -1, users);
        // ------
        listView.setAdapter(adapterString);

        int i = 10;
        i  = 12;

    }
}
