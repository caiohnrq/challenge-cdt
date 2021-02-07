package com.cdt.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdt.app.api.dto.request.PaymentReqDto;
import com.cdt.app.mapper.PaymentMapper;
import com.cdt.app.model.OrderEntity;
import com.cdt.app.model.PaymentEntity;
import com.cdt.app.repository.PaymentRepository;
import com.cdt.app.util.OrderStatusEnum;
import com.cdt.app.util.PaymentStatusEnum;

@Service
public class PaymentService {
	
	@Autowired
    private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderService orderService;

	public PaymentEntity executePayment(PaymentReqDto dto) throws Exception {
		OrderEntity orderEntity = orderService.findOrderById(dto.getOrderId());
		
		PaymentEntity paymentEntity = new PaymentMapper().dtoToEntity(dto);
		paymentEntity.setOrder(orderEntity);
		paymentEntity.setPaymentDate(new Date());
		paymentEntity.setStatus(PaymentStatusEnum.APROVADO.getStatus());
		
		try {
			paymentRepository.save(paymentEntity);
			
		} catch (Exception e) {
			orderService.rejectOrder(orderEntity);
		}
		orderService.confirmOrder(orderEntity);
		
		return paymentEntity;
	}

	public PaymentEntity refundPayment(PaymentReqDto dto) throws Exception {
		OrderEntity orderEntity = orderService.findOrderById(dto.getOrderId());
		
		if(orderEntity.getStatus() != OrderStatusEnum.APROVADO.getStatus()) {
			throw new Exception("Não é possível realizar o reembolse deste pedido");
		}
		
		PaymentEntity paymentEntity = new PaymentMapper().dtoToEntity(dto);
		paymentEntity.setStatus(PaymentStatusEnum.REEMBOLSADO.getStatus());
		
		paymentRepository.save(paymentEntity);
		orderService.refundOrder(orderEntity);
		
		return paymentEntity;
	}
}
