package com.example.jpaTutorial.jpaTutorial.dto;

import jdk.jshell.Snippet;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponseDTO {
    private Long id;
    private String sku;
    private String title;
    private BigDecimal price;
    private Integer quantity;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
