package com.maq.challenge.persistence;

import com.maq.challenge.domain.DinoStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Dinosaur")
@Table(name = "dinosaurs")
@Data
@EqualsAndHashCode()
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DinosaurDE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String species;

    @Column
    private LocalDateTime discoveryDate;

    @Column
    private LocalDateTime extinctionDate;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private DinoStatus status = DinoStatus.ALIVE;

}
