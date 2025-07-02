package com.maq.challenge.service;

import com.maq.challenge.MockHelper;
import com.maq.challenge.domain.Dinosaur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DinosaurServiceTest {

    @Autowired
    private DinosaurService dinosaurService;

    @DisplayName("Test crear dinosaurio en H2")
    @Test
    public void testCreateDinosaur() {

        Dinosaur dinosaurMock = MockHelper.createDinosaurMock("T-Rex");
        Dinosaur insertedDino = dinosaurService.create(dinosaurMock);
        assertEquals(dinosaurMock, insertedDino);
    }

}
