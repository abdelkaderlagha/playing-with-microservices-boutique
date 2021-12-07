package io.gadour.productservice.web;

import io.gadour.productservice.commons.Web;
import io.gadour.productservice.service.ProductService;
import io.gadour.productservice.web.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
@RequestMapping(Web.API+"products")
public class ProductRessource {

    private final ProductService productService;

    @Autowired
    public ProductRessource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Set<ProductDto> findAll(){
        return this.productService.findAll();
    }

    @GetMapping( "/{id}")
    public ProductDto findById(@PathVariable Long id) throws Exception {
        return this.productService.findById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) throws Exception {
        return this.productService.create(productDto);
    }

    @GetMapping("/entrepot/{id}")
    public Set<ProductDto> findAllByEntrepotId(@PathVariable Long id){
        return this.productService.findAllByEntrepotId(id);
    }

    @DeleteMapping( "/{id}")
    public void delete(@PathVariable Long id){
        this.productService.deleteById(id);
    }

}
