package com.vampire.RetailService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vampire.RetailService.model.OrderRequest;

@Repository
public interface RetailRepository extends JpaRepository<OrderRequest, Long>{

}
