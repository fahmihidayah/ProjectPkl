package com.widsons.pklproj.model;

import com.google.gson.annotations.SerializedName;

public class Siswa{

	@SerializedName("umur")
	private int umur;

	@SerializedName("address")
	private String address;

	@SerializedName("nama")
	private String nama;

	@SerializedName("bio")
	private String bio;

	@SerializedName("type")
	private int type;

	public void setUmur(int umur){
		this.umur = umur;
	}

	public int getUmur(){
		return umur;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Siswa{" + 
			"umur = '" + umur + '\'' + 
			",address = '" + address + '\'' + 
			",nama = '" + nama + '\'' + 
			",bio = '" + bio + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}