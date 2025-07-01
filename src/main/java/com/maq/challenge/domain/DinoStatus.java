package com.maq.challenge.domain;

import lombok.Getter;

@Getter
public enum DinoStatus {

    ALIVE("ALIVE"),
    ENDANGERED("ENDANGERED"),
    EXTINCT("EXTINCT");

    private final String status;

    DinoStatus(String status) {
        this.status = status;
    }

}
