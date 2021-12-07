package io.gadour.productservice.repository;

import io.gadour.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Set<Product> findAllByEntrepotId(Long entrepotId);
}
