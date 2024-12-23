package com.example.backend.services;

import java.util.List;
import com.example.backend.model.ProductType;
import org.springframework.stereotype.Service;

import com.example.backend.repository.ProductTypeRepository;

@Service
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }
    public List<com.example.backend.model.ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    public com.example.backend.model.ProductType saveProductType(com.example.backend.model.ProductType productType) {
        return productTypeRepository.save(productType);
    }
    
}
