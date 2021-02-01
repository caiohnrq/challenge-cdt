package com.cdt.app.mapper;

import java.util.List;

import com.cdt.app.api.dto.request.PaymentReqDto;
import com.cdt.app.api.dto.response.PaymentResDto;
import com.cdt.app.model.PaymentEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class PaymentMapper {
	
	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    
    public PaymentEntity dtoToEntity(PaymentResDto sippeDto) {
		return mapperFacade.map(sippeDto, PaymentEntity.class);
	}
    
    public PaymentEntity dtoToEntity(PaymentReqDto sippeDto) {
		return mapperFacade.map(sippeDto, PaymentEntity.class);
	}
    
    public PaymentResDto entityToDto(PaymentEntity entity) {
		return mapperFacade.map(entity, PaymentResDto.class);
	}
	
	public List<PaymentResDto> entitiesToDtos(List<PaymentEntity> entities){
		return mapperFacade.mapAsList(entities, PaymentResDto.class);
	}
}
