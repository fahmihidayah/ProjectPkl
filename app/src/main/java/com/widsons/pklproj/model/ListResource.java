package com.widsons.pklproj.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListResource{

	@SerializedName("per_page")
	private int perPage;

	@SerializedName("total")
	private int total;

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("data")
	private ArrayList<Resource> data;

	public void setPerPage(int perPage){
		this.perPage = perPage;
	}

	public int getPerPage(){
		return perPage;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	@Override
 	public String toString(){
		return 
			"ListResource{" + 
			"per_page = '" + perPage + '\'' + 
			",total = '" + total + '\'' + 
			",page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			"}";
		}

	public ArrayList<Resource> getData() {
		return data;
	}

	public void setData(ArrayList<Resource> data) {
		this.data = data;
	}
}