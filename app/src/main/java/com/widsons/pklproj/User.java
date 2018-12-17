package com.widsons.pklproj;

/**
 * Created on : December/17/2018
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class User {
    private int resImage = R.drawable.ic_launcher_background;
    private String nama;
    private String email;
    private String phone;

    public int getResImage() {
        return resImage;
    }

    public void setResImage(int resImage) {
        this.resImage = resImage;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}