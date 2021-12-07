package io.gadour.productservice.web.dto;

import io.gadour.productservice.commons.EntrepotDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private Long price;
    private Long categoryId;
    private Long brandId;
    private Long entrepotId;
}
