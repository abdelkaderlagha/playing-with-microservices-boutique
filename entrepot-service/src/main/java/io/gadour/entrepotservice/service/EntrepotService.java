package io.gadour.entrepotservice.service;

import io.gadour.entrepotservice.commons.ProductDto;
import io.gadour.entrepotservice.entity.Entrepot;
import io.gadour.entrepotservice.repository.EntrepotRepository;
import io.gadour.entrepotservice.repository.LocationRepository;
import io.gadour.entrepotservice.web.dtos.EntrepotDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class EntrepotService {

    private final EntrepotRepository entrepotRepository;
    private final LocationRepository locationRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public EntrepotService(EntrepotRepository entrepotRepository, LocationRepository locationRepository, RestTemplate restTemplate) {
        this.entrepotRepository = entrepotRepository;
        this.locationRepository = locationRepository;
        this.restTemplate = restTemplate;
    }

    public static EntrepotDto mapToDto(Entrepot entrepot){
        if(entrepot!=null){
            return new EntrepotDto(
                    entrepot.getId(),
                    entrepot.getEntrepotName(),
                    entrepot.getCapacity(),
                    entrepot.getLocation().getId()


            );
        }
        return null;
    }

    public Set<EntrepotDto> findAll(){
        return this.entrepotRepository.findAll().stream().map(EntrepotService::mapToDto).collect(Collectors.toSet());
    }

    public EntrepotDto findById(Long id) throws Exception {
        return this.entrepotRepository.findById(id).map(EntrepotService::mapToDto).orElseThrow(()->new Exception("Entrepot not available"));
    }

    public EntrepotDto create(EntrepotDto entrepotDto) throws Exception {
        return mapToDto(this.entrepotRepository.save(
                new Entrepot(
                        entrepotDto.getEntrepotName(),
                        entrepotDto.getCapacity(),
                        this.locationRepository.findById(entrepotDto.getLocationId()).orElseThrow(()->new Exception("Location is not available!"))
                )
        ));
    }

    public void delete(Long id){
        this.entrepotRepository.deleteById(id);
    }

    public EntrepotDto getCurrentCapacity(Long id) throws Exception {
        ResponseEntity<ProductDto[]> response = this.restTemplate.getForEntity("http://PRODUCT-SERVICE/api/v1/products/entrepot/{id}", ProductDto[].class, id);
        ProductDto[] productList = response.getBody();

        EntrepotDto entrepot = this.entrepotRepository.findById(id).map(EntrepotService::mapToDto).orElseThrow(()->new Exception("The entrepot is not available"));
        entrepot.setCapacity(entrepot.getCapacity()- productList.length);

        return entrepot;
    }
}
