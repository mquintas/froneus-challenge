package com.maq.challenge.persistence.mappers;

import com.maq.challenge.domain.DinoStatus;
import com.maq.challenge.domain.Dinosaur;
import com.maq.challenge.persistence.DinosaurDE;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DinosaurMapper {

     public DinosaurDE toEntity(Dinosaur dinosaur) {
         DinoStatus alive = DinoStatus.ALIVE;
         return DinosaurDE.builder()
                 .id(dinosaur.getId())
                 .name(dinosaur.getName())
                 .species(dinosaur.getSpecies())
                 .discoveryDate(dinosaur.getDiscoveryDate())
                 .extinctionDate(dinosaur.getExtinctionDate())
                 .status( Optional.ofNullable(dinosaur.getStatus()).orElse(DinoStatus.ALIVE)) // no puepo usar elvis operator, uso optional
                 .build();
     }

    public Dinosaur toDomain(DinosaurDE dinosaur) {
        return Dinosaur.builder()
                .id(dinosaur.getId())
                .name(dinosaur.getName())
                .species(dinosaur.getSpecies())
                .discoveryDate(dinosaur.getDiscoveryDate())
                .extinctionDate(dinosaur.getExtinctionDate())
                .status(dinosaur.getStatus())
                .build();
    }

}
