package com.widsons.pklproj.remote;

import com.widsons.pklproj.model.ListResource;
import com.widsons.pklproj.model.ListUserResponse;
import com.widsons.pklproj.model.UserDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created on : January/09/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public interface ApiService {
    @GET("users/{id}")
    Call<UserDataResponse> requestUserDetail(@Path("id") String id);

    @GET("users")
    Call<ListUserResponse> requestListUser(@Query("page") int page);

    @POST("users")
    @FormUrlEncoded
    void requestCreateUser(@Field("name") String name, @Field("job") String job);

    @GET("unknown")
    Call<ListResource> getResource(@Query("page") int page);
}
