package io.gadour.entrepotservice.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private Long price;
    private Long categoryId;
    private Long brandId;
    private Long entrepotId;
}
