package com.maq.challenge.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Builder
public class Dinosaur {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String species;

    @NotNull
    private LocalDateTime discoveryDate;

    private LocalDateTime extinctionDate;

    private DinoStatus status;// = DinoStatus.ALIVE;

}
