package com.cdt.app.api.dto.request;

import java.io.Serializable;

public class StoreReqDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private String name;
    private String adress;
    
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
