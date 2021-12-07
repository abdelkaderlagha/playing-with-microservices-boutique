package io.gadour.productservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String categoryName;
    private Integer products;

}
