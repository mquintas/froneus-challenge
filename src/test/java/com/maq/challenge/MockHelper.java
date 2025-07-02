package com.maq.challenge;

import com.maq.challenge.domain.DinoStatus;
import com.maq.challenge.domain.Dinosaur;
import com.maq.challenge.persistence.DinosaurDE;

import java.time.LocalDateTime;

public class MockHelper {


    public static Dinosaur createDinosaurMock(String name) {

        return Dinosaur.builder()
                        .name(name)
                        .species("Especie")
                        .discoveryDate(LocalDateTime.parse("1002-01-01T23:59:59"))
                        .extinctionDate(LocalDateTime.parse("1102-01-01T23:59:59"))
                        .status(DinoStatus.ALIVE)
                        .build();
    }

    public static Dinosaur createDinosaurMockWithId(Long id, String name) {
        Dinosaur dino =
                Dinosaur.builder()
                        .id(id)
                        .name(name)
                        .species("Especie")
                        .discoveryDate(LocalDateTime.parse("1002-01-01T23:59:59"))
                        .extinctionDate(LocalDateTime.parse("1102-01-01T23:59:59"))
                        .status(DinoStatus.ALIVE)
                        .build();
        return dino;
    }


    public static DinosaurDE createDinosaurDEMock(Long id, String name) {

        return DinosaurDE.builder()
                .name(name)
                .species("Especie")
                .discoveryDate(LocalDateTime.parse("1002-01-01T23:59:59"))
                .extinctionDate(LocalDateTime.parse("1102-01-01T23:59:59"))
                .status(DinoStatus.ALIVE)
                .build();

    }

}
