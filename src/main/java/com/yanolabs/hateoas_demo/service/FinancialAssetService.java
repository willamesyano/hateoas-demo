package com.yanolabs.hateoas_demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yanolabs.hateoas_demo.model.FinancialAssetModel;
import com.yanolabs.hateoas_demo.repository.FinancialAssetRepository;

@Service
public class FinancialAssetService {
    @Autowired
    FinancialAssetRepository financialAssetRepository;
    
    @Transactional
    public FinancialAssetModel save(final FinancialAssetModel financialAsset) throws Exception {
        return findById(financialAssetRepository.save(financialAsset).getId()).get();
    }

    @Transactional
    public void update(final FinancialAssetModel financialAsset) {
        financialAssetRepository.save(financialAsset);
    }

    @Transactional
    public void delete(final FinancialAssetModel financialAsset) {
        financialAssetRepository.delete(financialAsset);
    }

    public List<FinancialAssetModel> listAll() {
        return financialAssetRepository.findAll();
    }
    
    public Optional<FinancialAssetModel> findById(final int id) throws Exception {
        return financialAssetRepository.findById(id);
    }
}