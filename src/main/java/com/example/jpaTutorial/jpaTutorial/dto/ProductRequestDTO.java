package com.example.jpaTutorial.jpaTutorial.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "Required field is :sku")
    private String sku;

    @NotBlank(message = "Required field is :title")
    private String title;

    @NotNull(message = "Cant be Null field:price")
    private BigDecimal price;

    @NotNull(message = "Cant be Null field:quantity")
    private Integer quantity;
}
