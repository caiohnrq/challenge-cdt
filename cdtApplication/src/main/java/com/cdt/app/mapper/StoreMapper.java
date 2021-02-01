package com.cdt.app.mapper;

import java.util.List;

import com.cdt.app.api.dto.request.StoreReqDto;
import com.cdt.app.api.dto.response.StoreResDto;
import com.cdt.app.model.StoreEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class StoreMapper {
	
	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    
    public StoreEntity dtoToEntity(StoreResDto sippeDto) {
		return mapperFacade.map(sippeDto, StoreEntity.class);
	}
    
    public StoreEntity dtoToEntity(StoreReqDto sippeDto) {
		return mapperFacade.map(sippeDto, StoreEntity.class);
	}
    
    public StoreResDto entityToDto(StoreEntity entity) {
		return mapperFacade.map(entity, StoreResDto.class);
	}
	
	public List<StoreResDto> entitiesToDtos(List<StoreEntity> entities){
		return mapperFacade.mapAsList(entities, StoreResDto.class);
	}
}
