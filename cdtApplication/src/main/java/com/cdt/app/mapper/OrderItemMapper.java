package com.cdt.app.mapper;

import java.util.List;

import com.cdt.app.api.dto.request.OrderItemReqDto;
import com.cdt.app.api.dto.response.OrderItemResDto;
import com.cdt.app.model.OrderItemEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrderItemMapper {
	
	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    
    public OrderItemEntity dtoToEntity(OrderItemReqDto sippeDto) {
		return mapperFacade.map(sippeDto, OrderItemEntity.class);
	}
    
    public OrderItemEntity dtoToEntity(OrderItemResDto sippeDto) {
		return mapperFacade.map(sippeDto, OrderItemEntity.class);
	}
    
    public OrderItemResDto entityToDto(OrderItemEntity entity) {
		return mapperFacade.map(entity, OrderItemResDto.class);
	}
	
	public List<OrderItemResDto> entitiesToDtos(List<OrderItemEntity> entities){
		return mapperFacade.mapAsList(entities, OrderItemResDto.class);
	}
}
