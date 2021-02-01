package com.cdt.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdt.app.api.dto.request.StoreReqDto;
import com.cdt.app.mapper.StoreMapper;
import com.cdt.app.model.StoreEntity;
import com.cdt.app.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
    private StoreRepository storeRepository;

	public List<StoreEntity> findAllStore() {
		return storeRepository.findAll();
	}

	public StoreEntity findStoreByName(String name) {
		return storeRepository.findByName(name);
	}

	public StoreEntity saveStore(StoreReqDto dto) {
		StoreEntity store = new StoreMapper().dtoToEntity(dto);
		return storeRepository.save(store);
	}

	public Optional<StoreEntity> findById(Long storeId) {
		return storeRepository.findById(storeId);
	}
}
