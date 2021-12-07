package io.gadour.productservice.web;

import io.gadour.productservice.commons.Web;
import io.gadour.productservice.service.BrandService;
import io.gadour.productservice.web.dto.BrandDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
@RequestMapping(Web.API+"products/brands")
public class BrandRessource {

    private final BrandService brandService;

    @Autowired
    public BrandRessource(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public Set<BrandDto> findAll(){
        return this.brandService.findAll();
    }

    @GetMapping("/{id}")
    public BrandDto findById(@PathVariable Long id) throws Exception {
        return this.brandService.findById(id);
    }

    @PostMapping
    public BrandDto create(@RequestBody BrandDto brandDto){
        return this.brandService.create(brandDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.brandService.delete(id);
    }
}
