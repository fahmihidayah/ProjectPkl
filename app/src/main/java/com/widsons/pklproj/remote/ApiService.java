package com.widsons.pklproj.remote;

import com.widsons.pklproj.model.UserDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created on : January/09/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public interface ApiService {
    @GET("users/{id}")
    Call<UserDataResponse> requestUserDetail(@Path("id") String id);
}
