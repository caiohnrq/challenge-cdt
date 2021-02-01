package com.cdt.app.api.dto.request;

import java.io.Serializable;
import java.util.List;

public class OrderReqDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private String address;
    private Long storeId;
    private List<OrderItemReqDto> orderItem;
    
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public List<OrderItemReqDto> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItemReqDto> orderItem) {
		this.orderItem = orderItem;
	}
}
