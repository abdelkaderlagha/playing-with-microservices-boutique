package io.gadour.productservice.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntrepotDto {
    private Long id;
    private String entrepotName;
    private Long capacity;
    private Long locationId;
}
