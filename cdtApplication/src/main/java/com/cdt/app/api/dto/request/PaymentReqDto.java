package com.cdt.app.api.dto.request;

import java.io.Serializable;

public class PaymentReqDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long orderId;
    private String creditCard;
    
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
}
