package io.gadour.entrepotservice.web;

import io.gadour.entrepotservice.commons.Web;
import io.gadour.entrepotservice.service.LocationService;
import io.gadour.entrepotservice.web.dtos.LocationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
@RequestMapping(Web.API +"entrepots/locations")
public class LocationRessource {

    private final LocationService locationService;

    @Autowired
    public LocationRessource(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public Set<LocationDto> findAll(){
        return this.locationService.findALl();
    }

    @GetMapping("/{id}")
    public LocationDto findById(@PathVariable Long id) throws Exception {
        return this.locationService.findById(id);
    }

    @PostMapping
    public LocationDto create (@RequestBody LocationDto locationDto){
        return this.locationService.create(locationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.locationService.deleteById(id);
    }
}
