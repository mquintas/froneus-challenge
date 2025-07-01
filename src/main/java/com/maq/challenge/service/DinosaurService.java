package com.maq.challenge.service;

import com.maq.challenge.domain.Dinosaur;
import com.maq.challenge.domain.DinoStatus;
import com.maq.challenge.exception.DinosaurNotFoundException;
import com.maq.challenge.persistence.DinosaurDE;
import com.maq.challenge.persistence.mappers.DinosaurMapper;
import com.maq.challenge.persistence.repository.DinosaurRepository;
import com.maq.challenge.exception.DinosaurException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Log4j2
@Service
@Transactional
public class DinosaurService {

    private final DinosaurRepository repository;
    private final DinosaurMapper mapper;

    @Autowired
    public DinosaurService(DinosaurRepository repository, DinosaurMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Dinosaur create(Dinosaur dinosaur) {
        validateDinosaur(dinosaur);
        if (repository.existsByName(dinosaur.getName())) {
            throw new DinosaurException("Dinosaur name must be unique");
        }
        return mapper.toDomain(repository.save(mapper.toEntity(dinosaur)));
    }

    public Dinosaur update(Long id, Dinosaur dinosaur) {
        DinosaurDE existing = repository.findById(id)
                .orElseThrow(() -> new DinosaurNotFoundException("El Dinosaurio no existe"));

        if (existing.getStatus() == DinoStatus.EXTINCT) {
            throw new DinosaurException("No se puede actualizar un dinosaurio extinto");
        }

        validateDinosaur(dinosaur);

        if (dinosaur.getName() != null) existing.setName(dinosaur.getName());
        if (dinosaur.getSpecies() != null) existing.setSpecies(dinosaur.getSpecies());
        if (dinosaur.getDiscoveryDate() != null) existing.setDiscoveryDate(dinosaur.getDiscoveryDate());
        if (dinosaur.getExtinctionDate() != null) existing.setExtinctionDate(dinosaur.getExtinctionDate());
        if (dinosaur.getStatus() != null) existing.setStatus(dinosaur.getStatus());

        try {
            return mapper.toDomain(repository.save(existing));
        } catch (DataIntegrityViolationException e) {
            //tambien puedo usar el repository.existsByName(dinosaur.getName()) pero implica una query extra.
            throw new DinosaurException("Ya existe un dinosaurio con ese nombre");
        }
    }

    private void validateDinosaur(Dinosaur dinosaur) {
        if (dinosaur.getDiscoveryDate() != null && dinosaur.getExtinctionDate() != null &&
                dinosaur.getDiscoveryDate().isAfter(dinosaur.getExtinctionDate())) {
            throw new DinosaurException("discoveryDate no puede ser mayor o igual al valor de extinctionDate");
        }
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new DinosaurNotFoundException("Dinosaur does not exist");
        }
        repository.deleteById(id);
    }

    public List<Dinosaur> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    public Dinosaur findById(Long id) {
        return mapper.toDomain(repository.findById(id).orElseThrow(() -> new DinosaurNotFoundException("El Dinosaurio no existe")));
    }
}