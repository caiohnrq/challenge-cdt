package com.cdt.app.api.dto.response;

import java.io.Serializable;

public class StoreResDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long storeId;
    private String name;
    private String adress;

	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
