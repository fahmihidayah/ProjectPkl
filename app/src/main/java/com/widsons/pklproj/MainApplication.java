package com.widsons.pklproj;

import android.app.Application;

import com.google.gson.Gson;
import com.widsons.pklproj.remote.ApiService;
import com.widsons.pklproj.remote.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on : January/09/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class MainApplication extends Application {

    private ApiService apiService;

    public ApiService getApiService() {
        return apiService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initialRetrofit();
    }

    private void initialRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        apiService = retrofit.create(ApiService.class);
    }
}
