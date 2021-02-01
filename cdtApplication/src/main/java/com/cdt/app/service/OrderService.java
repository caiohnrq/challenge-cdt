package com.cdt.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdt.app.api.dto.request.OrderItemReqDto;
import com.cdt.app.api.dto.request.OrderReqDto;
import com.cdt.app.mapper.OrderItemMapper;
import com.cdt.app.mapper.OrderMapper;
import com.cdt.app.model.OrderEntity;
import com.cdt.app.model.OrderItemEntity;
import com.cdt.app.model.StoreEntity;
import com.cdt.app.repository.OrderRepository;
import com.cdt.app.util.OrderStatusEnum;

@Service
public class OrderService {
	
	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
	private StoreService storeService;

	public List<OrderEntity> findAllOrders() {
		return orderRepository.findAll();
	}

	public OrderEntity findOrderById(Long id) throws Exception {
		return orderRepository.findById(id).orElseThrow(() -> new Exception(String.format("Não foi possível encontrar o pedido %s", id)));
	}

	public OrderEntity saveOrder(OrderReqDto dto) throws Exception {
		StoreEntity storeEntity = storeService.findById(dto.getStoreId()).orElseThrow(() -> new Exception(String.format("Não foi possível encontrar a loja de ID: %s", dto.getStoreId())));
		
		OrderEntity order = new OrderMapper().dtoToEntity(dto);
		order.setStatus(OrderStatusEnum.EM_ANDAMENTO.getStatus());
		order.setStore(storeEntity);
		
		order.setOrderItems(saveOrderItems(dto.getOrderItem(), order));
		
		return orderRepository.save(order);
	}

	private List<OrderItemEntity> saveOrderItems(List<OrderItemReqDto> orderItems, OrderEntity order) {
		List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();
		
		for(OrderItemReqDto item : orderItems) {
			OrderItemEntity orderItem = new OrderItemMapper().dtoToEntity(item);
			orderItemList.add(orderItem);
		}
		
		return orderItemList;
	}
	
	public OrderEntity confirmOrder(OrderEntity entity) {
		entity.setConfirmationDate(new Date());
		entity.setStatus(OrderStatusEnum.APROVADO.getStatus());
		
		return orderRepository.save(entity);
	}
	
	public  OrderEntity cancelOrder(OrderEntity entity) {
		entity.setStatus(OrderStatusEnum.CANCELADO.getStatus());
		
		return orderRepository.save(entity);
	}
	
	public OrderEntity rejectOrder(OrderEntity entity) {
		entity.setStatus(OrderStatusEnum.REJEITADO.getStatus());
		
		return orderRepository.save(entity);
	}

	public OrderEntity refundOrder(OrderEntity entity) {
		entity.setStatus(OrderStatusEnum.REEMBOLSADO.getStatus());
		
		return orderRepository.save(entity);
	}
}
