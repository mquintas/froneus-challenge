package com.maq.challenge.persistence.repository;

import com.maq.challenge.persistence.DinosaurDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinosaurRepository extends JpaRepository<DinosaurDE, Long> {
    boolean existsByName(String name);
}
