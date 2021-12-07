package io.gadour.productservice.repository;

import io.gadour.productservice.entity.BrandMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandMarkRepository extends JpaRepository<BrandMark, Long> {
}
