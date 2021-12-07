package io.gadour.entrepotservice.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class EntrepotDto {
    private Long id;
    private String entrepotName;
    private Long capacity;
    private Long locationId;
}
