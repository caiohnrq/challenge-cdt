package com.cdt.app.api.dto.response;

import java.io.Serializable;
import java.util.Date;

import com.cdt.app.util.PaymentStatusEnum;

public class PaymentResDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long paymentId;
    private String creditCard;
    private Date paymentDate;
    private Long status;
    private String statusDescription;
    
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getStatusDescription() {
		statusDescription = PaymentStatusEnum.getDescStatus(status).getDescStatus();
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
