package com.yanolabs.hateoas_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yanolabs.hateoas_demo.model.FinancialAssetModel;

@Repository
public interface FinancialAssetRepository extends JpaRepository<FinancialAssetModel, Integer> {

}
