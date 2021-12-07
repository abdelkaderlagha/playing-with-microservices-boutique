package io.gadour.entrepotservice.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class LocationDto {
    private Long id;
    private String LocationName;
    private Set<EntrepotDto> entrepots;
}
