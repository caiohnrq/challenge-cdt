package com.cdt.app.util;

public enum OrderStatusEnum {
	
	EM_ANDAMENTO(0L, "Em Andamento"),
	APROVADO(1L, "Aprovado"),
	REJEITADO(2L, "Rejeitado"),
	CANCELADO(3L, "Cancelado"),
	REEMBOLSADO(4L, "Reembolsado");
	
	private Long status;
	private String descStatus;
	
	OrderStatusEnum(Long status, String descStatus) {
		setStatus(status);
		setDescStatus(descStatus);
	}

	public static OrderStatusEnum getDescStatus(Long status) {
		for (OrderStatusEnum temp : values()) {
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
