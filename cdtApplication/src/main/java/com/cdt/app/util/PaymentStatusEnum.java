package com.cdt.app.util;

public enum PaymentStatusEnum {
	
	APROVADO(1L, "Aprovado"),
	REJEITADO(2L, "Rejeitado"),
	CANCELADO(3L, "Cancelado"),
	REEMBOLSADO(4L, "Reembolsado");
	
	private Long status;
	private String descStatus;
	
	PaymentStatusEnum(Long status, String descStatus) {
		setStatus(status);
		setDescStatus(descStatus);
	}

	public static PaymentStatusEnum getDescStatus(Long status) {
		for (PaymentStatusEnum temp : values()) {
            if (temp.status == status) {
                return temp;
            }
        }
		return null;
	}

	public Long getStatus() {
		return status;
	}

	private void setStatus(Long status) {
		this.status = status;
	}

	public String getDescStatus() {
		return descStatus;
	}

	private void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}
}
