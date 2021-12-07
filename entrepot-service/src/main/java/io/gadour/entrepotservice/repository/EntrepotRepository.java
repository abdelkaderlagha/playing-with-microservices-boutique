package io.gadour.entrepotservice.repository;

import io.gadour.entrepotservice.entity.Entrepot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepotRepository extends JpaRepository<Entrepot, Long> {
}
