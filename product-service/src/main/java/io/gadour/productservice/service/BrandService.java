package io.gadour.productservice.service;

import io.gadour.productservice.entity.BrandMark;
import io.gadour.productservice.repository.BrandMarkRepository;
import io.gadour.productservice.repository.ProductRepository;
import io.gadour.productservice.web.dto.BrandDto;
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
public class BrandService {

    private final BrandMarkRepository brandMarkRepository;
    private final ProductRepository productRepository;

    @Autowired
    public BrandService(BrandMarkRepository brandMarkRepository, ProductRepository productRepository) {
        this.brandMarkRepository = brandMarkRepository;
        this.productRepository = productRepository;
    }

    public static BrandDto mapToDto(BrandMark brandMark){
        log.info("Exceuting mapToDto in BrandService {}");
        if(brandMark !=null){
            return new BrandDto(
                    brandMark.getId(),
                    brandMark.getBrandName(),
                    brandMark.getProducts().stream().map(ProductService::mapToDto).collect(Collectors.toSet())
            );
        }
        return null;
    }

    public BrandDto create(BrandDto brandMark){
        log.info("Exceuting create in BrandService {}");
        return mapToDto(this.brandMarkRepository.save(
                new BrandMark(
                        brandMark.getBrandName(),
                        Collections.emptySet()
                )
        ));
    }

    public Set<BrandDto> findAll(){
        log.info("Exceuting findAll in BrandService {}");
        return this.brandMarkRepository.findAll().stream().map(BrandService::mapToDto).collect(Collectors.toSet());
    }

    public BrandDto findById(Long id) throws Exception {
        log.info("Exceuting findById in BrandService {}");
        return this.brandMarkRepository.findById(id).map(BrandService::mapToDto).orElseThrow(()-> new Exception("Brand not available"));
    }

    public void delete(Long id){
        log.info("Exceuting delete in BrandService {}");
        this.brandMarkRepository.deleteById(id);
    }
}
