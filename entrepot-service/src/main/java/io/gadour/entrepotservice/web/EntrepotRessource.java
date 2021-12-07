package io.gadour.entrepotservice.web;

import io.gadour.entrepotservice.commons.Web;
import io.gadour.entrepotservice.service.EntrepotService;
import io.gadour.entrepotservice.web.dtos.EntrepotDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(Web.API+"entrepots")
@Slf4j
public class EntrepotRessource {

    private final EntrepotService entrepotService;

    @Autowired
    public EntrepotRessource(EntrepotService entrepotService) {
        this.entrepotService = entrepotService;
    }

    @GetMapping
    public Set<EntrepotDto> findALl(){
        return this.entrepotService.findAll();
    }

    @GetMapping("/{id}")
    public EntrepotDto findById(@PathVariable Long id) throws Exception {
        return this.entrepotService.findById(id);
    }

    @PostMapping
    public EntrepotDto create(@RequestBody EntrepotDto entrepotDto) throws Exception {
        return this.entrepotService.create(entrepotDto);
    }

    @GetMapping("/capacity/{id}")
    public EntrepotDto getCurrentCapacity(@PathVariable Long id) throws Exception {
        return this.entrepotService.getCurrentCapacity(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.entrepotService.delete(id);
    }
}
