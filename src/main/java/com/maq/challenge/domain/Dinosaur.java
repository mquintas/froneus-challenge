package com.maq.challenge.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Builder
public class Dinosaur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;

    @NotNull
    private String species;

    @NotNull
    private LocalDateTime discoveryDate;

    private LocalDateTime extinctionDate;

    @Enumerated(EnumType.STRING)
    private DinoStatus status = DinoStatus.ALIVE;

    public String getName() {
        return null;
    }
}
