package com.maq.challenge.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.maq.challenge.MockHelper;
import com.maq.challenge.domain.Dinosaur;
import com.maq.challenge.persistence.DinosaurDE;
import com.maq.challenge.persistence.mappers.DinosaurMapper;
import com.maq.challenge.persistence.repository.DinosaurRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DinosaurServiceTestConMocks {

    @Mock
    private DinosaurRepository dinosaurRepository;

    @Mock
    private DinosaurMapper mapper;

    @InjectMocks
    private DinosaurService dinosaurService;

    @BeforeAll
    public static void beforeAll() {
        MockitoAnnotations.openMocks(DinosaurServiceTestConMocks.class);
    }

    @DisplayName("Test crear dinosaurio con repository mock")
    @Test public void testEntitySave() {

        Dinosaur model = MockHelper.createDinosaurMock("T-Rex");
        DinosaurDE modelDE = MockHelper.createDinosaurDEMock(1L, "T-Rex");

        when(this.dinosaurRepository.save(any(DinosaurDE.class))).thenReturn(modelDE);
        when(this.mapper.toDomain(any(DinosaurDE.class))).thenReturn(model);
        when(this.mapper.toEntity(any(Dinosaur.class))).thenReturn(modelDE);
        Dinosaur retrieved = dinosaurService.create( model );
        assertNotNull( retrieved.getName() );
        assertNotNull( model.getName() );
        assertEquals( retrieved, model );
    }

}