package com.demo.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductRestResponse {
    private String name;
    private BigDecimal price;
    private int quantity;
}
