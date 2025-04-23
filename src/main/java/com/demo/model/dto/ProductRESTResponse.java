package com.demo.model.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductRESTResponse {
    private String name;
    private BigDecimal price;
    private int quantity;
}
