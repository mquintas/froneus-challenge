package com.maq.challenge.persistence.mappers;

import com.maq.challenge.domain.Dinosaur;
import com.maq.challenge.persistence.DinosaurDE;
import org.springframework.stereotype.Component;

@Component
public class DinosaurMapper {

     public DinosaurDE toEntity(Dinosaur dinosaur) {
         return DinosaurDE.builder()
                 .id(dinosaur.getId())
                 .name(dinosaur.getName())
                 .species(dinosaur.getSpecies())
                 .discoveryDate(dinosaur.getDiscoveryDate())
                 .extinctionDate(dinosaur.getExtinctionDate())
                 .build();
     }

    public Dinosaur toDomain(DinosaurDE dinosaur) {
        return Dinosaur.builder()
                .id(dinosaur.getId())
                .name(dinosaur.getName())
                .species(dinosaur.getSpecies())
                .discoveryDate(dinosaur.getDiscoveryDate())
                .extinctionDate(dinosaur.getExtinctionDate())
                .build();
    }

}
