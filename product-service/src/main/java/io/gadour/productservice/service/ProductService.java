package io.gadour.productservice.service;

import io.gadour.productservice.commons.EntrepotDto;
import io.gadour.productservice.entity.Product;
import io.gadour.productservice.repository.BrandMarkRepository;
import io.gadour.productservice.repository.CategoryRepository;
import io.gadour.productservice.repository.ProductRepository;
import io.gadour.productservice.web.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandMarkRepository brandMarkRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, BrandMarkRepository brandMarkRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandMarkRepository = brandMarkRepository;
        this.restTemplate = restTemplate;
    }

    public static ProductDto mapToDto(Product product){
        log.info("Exceuting mapToDto in ProductService {}");
        if(product != null){
            return new ProductDto(
                    product.getId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getCategory().getId(),
                    product.getBrand().getId(),
                    product.getEntrepotId()
            );
        }
        return null;
    }

    public Set<ProductDto> findAll(){
        log.info("Exceuting findAll in ProductService {}");
        return this.productRepository.findAll().stream().map(ProductService::mapToDto).collect(Collectors.toSet());
    }

    public ProductDto findById(Long id) throws Exception {
        log.info("Exceuting findById in ProductService {}");
        return this.productRepository.findById(id).map(ProductService::mapToDto).orElseThrow(()->new Exception("Product not available"));
    }

    public ProductDto create(ProductDto product) throws Exception {
        log.info("Exceuting create in ProductService {}");
        ResponseEntity<EntrepotDto> entrepotDtoResponseEntity = this.restTemplate.getForEntity("http://ENTREPOT-SERVICE/api/v1/entrepots/{id}", EntrepotDto.class, product.getEntrepotId());
        ProductDto productDto = mapToDto(this.productRepository.save(
                new Product(
                        product.getProductName(),
                        product.getPrice(),
                        this.categoryRepository.findById(product.getCategoryId()).orElseThrow(() -> new Exception("Category not available")),
                        this.brandMarkRepository.findById(product.getBrandId()).orElseThrow(() -> new Exception("Brand not available")),
                        entrepotDtoResponseEntity.getBody().getId()
                )
        ));
        return productDto;
    }

    public void deleteById(Long id){
        log.info("Exceuting deleteById in ProductService {}");
        this.productRepository.deleteById(id);
    }

    public Set<ProductDto> findAllByEntrepotId(Long entrepotId){
        return this.productRepository.findAllByEntrepotId(entrepotId).stream().map(ProductService::mapToDto).collect(Collectors.toSet());

    }
}
