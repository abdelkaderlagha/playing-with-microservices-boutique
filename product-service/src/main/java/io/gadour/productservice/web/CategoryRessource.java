package io.gadour.productservice.web;

import io.gadour.productservice.commons.Web;
import io.gadour.productservice.service.CategoryService;
import io.gadour.productservice.web.dto.CategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
@RequestMapping(Web.API+"products/categories")
public class CategoryRessource {

    private final CategoryService categoryService;

    @Autowired
    public CategoryRessource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Set<CategoryDto> findAll(){
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) throws Exception {
        return this.categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto create(@RequestBody CategoryDto categoryDto){
        return this.categoryService.create(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.categoryService.deleteById(id);
    }
}
