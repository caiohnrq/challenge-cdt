package com.cdt.app.mapper;

import java.util.List;

import com.cdt.app.api.dto.request.OrderReqDto;
import com.cdt.app.api.dto.response.OrderResDto;
import com.cdt.app.model.OrderEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrderMapper {
	
	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    
    public OrderEntity dtoToEntity(OrderResDto sippeDto) {
		return mapperFacade.map(sippeDto, OrderEntity.class);
	}
    
    public OrderEntity dtoToEntity(OrderReqDto sippeDto) {
		return mapperFacade.map(sippeDto, OrderEntity.class);
	}
    
    public OrderResDto entityToDto(OrderEntity entity) {
		return mapperFacade.map(entity, OrderResDto.class);
	}
	
	public List<OrderResDto> entitiesToDtos(List<OrderEntity> entities){
		return mapperFacade.mapAsList(entities, OrderResDto.class);
	}
}
