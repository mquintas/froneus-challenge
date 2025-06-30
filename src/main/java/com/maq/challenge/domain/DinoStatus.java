package com.maq.challenge.domain;

import lombok.Getter;

@Getter
public enum DinoStatus {

    ALIVE("alive"),
    ENDANGERED("endangered"),
    EXTINCT("extinct");

    private final String status;

    DinoStatus(String status) {
        this.status = status;
    }

}
