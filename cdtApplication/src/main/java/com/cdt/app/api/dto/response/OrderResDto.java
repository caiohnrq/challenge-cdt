package com.cdt.app.api.dto.response;

import java.io.Serializable;

import com.cdt.app.util.OrderStatusEnum;

public class OrderResDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long orderId;
    private String address;
    private Long status;
    private String statusDescription;
    
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getStatusDescription() {
		statusDescription = OrderStatusEnum.getDescStatus(status).getDescStatus();
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
