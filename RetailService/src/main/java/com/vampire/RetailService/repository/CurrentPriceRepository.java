package com.vampire.RetailService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vampire.RetailService.model.CurrentPrice;

@Repository
public interface CurrentPriceRepository extends JpaRepository<CurrentPrice, Long> {

}
