package io.gadour.productservice.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class BrandDto {

    private Long id;
    private String brandName;
    private Set<ProductDto> products;
}
