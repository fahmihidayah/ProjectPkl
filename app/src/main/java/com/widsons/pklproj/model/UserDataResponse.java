package com.widsons.pklproj.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created on : January/09/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class UserDataResponse {
    @SerializedName("data")
    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
