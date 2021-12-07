package io.gadour.productservice.service;

import io.gadour.productservice.entity.Category;
import io.gadour.productservice.repository.CategoryRepository;
import io.gadour.productservice.repository.ProductRepository;
import io.gadour.productservice.web.dto.CategoryDto;
import io.gadour.productservice.web.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static CategoryDto mapToDto(Category category){
        log.info("Exceuting mapToDto in CategoryService {}");
        if(category !=null){
            return new CategoryDto(
                    category.getId(),
                    category.getCategoryName(),
                    category.getProducts().size()
            );
        }
        return null;
    }

    public CategoryDto create(CategoryDto category){
        log.info("Exceuting create in CategoryService {}");
        return mapToDto(this.categoryRepository.save(
                new Category(
                        category.getCategoryName(),
                        Collections.emptySet()
                )
        ));
    }

    public Set<CategoryDto> findAll(){
        log.info("Exceuting findAll in CategoryService {}");
        return this.categoryRepository.findAll().stream().map(CategoryService::mapToDto).collect(Collectors.toSet());
    }

    public CategoryDto findById(Long id) throws Exception {
        log.info("Exceuting findById in CategoryService {}");
        return this.categoryRepository.findById(id).map(CategoryService::mapToDto).orElseThrow(()-> new Exception("Category not available!"));
    }

    public void deleteById(Long id){
        log.info("Exceuting deleteById in CategoryService {}");
        this.categoryRepository.deleteById(id);
    }
}
