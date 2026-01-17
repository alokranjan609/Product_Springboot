package com.example.jpaTutorial.jpaTutorial.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductResponseDTO {
    private Long id;
    private String sku;
    private String title;
    private BigDecimal price;
    private Integer quantity;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
