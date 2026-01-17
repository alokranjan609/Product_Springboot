package com.example.jpaTutorial.jpaTutorial.repository;

import com.example.jpaTutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<ProductEntity, Long> {

    boolean existsBySku(String sku);
}
