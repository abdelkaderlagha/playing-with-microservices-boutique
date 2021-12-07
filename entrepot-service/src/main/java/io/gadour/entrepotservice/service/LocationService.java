package io.gadour.entrepotservice.service;

import io.gadour.entrepotservice.entity.Location;
import io.gadour.entrepotservice.repository.EntrepotRepository;
import io.gadour.entrepotservice.repository.LocationRepository;
import io.gadour.entrepotservice.web.dtos.LocationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class LocationService {

    private final LocationRepository locationRepository;
    private final EntrepotRepository entrepotRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, EntrepotRepository entrepotRepository) {
        this.locationRepository = locationRepository;
        this.entrepotRepository = entrepotRepository;
    }

    public static LocationDto mapToDto(Location location){
        if(location !=null){
            return new LocationDto(
                    location.getId(),
                    location.getLocationName(),
                    location.getEntrepots().stream().map(EntrepotService::mapToDto).collect(Collectors.toSet())
            );
        }
        return null;
    }

    public Set<LocationDto> findALl(){
        return this.locationRepository.findAll().stream().map(LocationService::mapToDto).collect(Collectors.toSet());
    }

    public LocationDto findById(Long id) throws Exception {
        return this.locationRepository.findById(id).map(LocationService::mapToDto).orElseThrow(()-> new Exception("Location not available"));
    }

    public LocationDto create(LocationDto locationDto){
        return mapToDto(this.locationRepository.save(
                new Location(
                        locationDto.getLocationName(),
                        Collections.emptySet()
                )
        ));
    }

    public void deleteById(Long id){
        this.locationRepository.deleteById(id);
    }
}
