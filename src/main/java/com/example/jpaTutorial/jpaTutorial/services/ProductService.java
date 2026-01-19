package com.example.jpaTutorial.jpaTutorial.services;

import com.example.jpaTutorial.jpaTutorial.dto.ProductRequestDTO;
import com.example.jpaTutorial.jpaTutorial.dto.ProductResponseDTO;
import com.example.jpaTutorial.jpaTutorial.entities.ProductEntity;
import com.example.jpaTutorial.jpaTutorial.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository,ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper=modelMapper;
    }

    /* CREATE */
    public ProductResponseDTO createProduct(ProductRequestDTO request) {

        if (productRepository.existsBySku(request.getSku())) {
            throw new IllegalArgumentException("Product with this SKU already exists");
        }
        ProductEntity product=modelMapper.map(request, ProductEntity.class);
        product.setCreatedAt(LocalDate.now());
        ProductEntity producttoreturn=productRepository.save(product);
        return modelMapper.map(producttoreturn, ProductResponseDTO.class);


    }


    /* READ ALL */
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductEntity> productEntities= productRepository.findAll();
        return productEntities
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    /* READ BY ID */
    public ProductResponseDTO getProductById(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        return modelMapper.map(product, ProductResponseDTO.class);
    }

    /* UPDATE */
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {
        ProductEntity product=modelMapper.map(request,ProductEntity.class);
        if(!productRepository.existsById(id))
            throw new RuntimeException("Product not found");

        product.setId(id);
        product.setUpdatedAt(LocalDate.now());


        ProductEntity savedPProduct=productRepository.save(product);

        return modelMapper.map(savedPProduct, ProductResponseDTO.class);
    }

    /* DELETE */
    public void deleteProduct(Long id) {

        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

}
