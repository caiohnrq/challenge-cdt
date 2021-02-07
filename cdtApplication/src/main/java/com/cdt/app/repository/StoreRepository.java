package com.cdt.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdt.app.model.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

	StoreEntity findByName(String name);

}
