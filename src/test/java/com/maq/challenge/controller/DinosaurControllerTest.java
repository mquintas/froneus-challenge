package com.maq.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maq.challenge.MockHelper;
import com.maq.challenge.domain.Dinosaur;
import com.maq.challenge.service.DinosaurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DinosaurControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DinosaurService dinosaurService;

//    @Autowired
//    private Gson gson;

    @Autowired
    private ObjectMapper jsonMapper;

    @Test
    void shouldGetDinosaurById() throws Exception {

        Dinosaur dino = dinosaurService.create( MockHelper.createDinosaurMock("T-Rex_"+ UUID.randomUUID()) );

        mockMvc.perform( get( "/dinosaur/" + dino.getId() ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "name" ).value( dino.getName() ) )
                .andExpect( jsonPath( "species" ).value( dino.getSpecies() ) );
    }


    @Test
    void shouldCreateDinosaurSuccessfully() throws Exception {

        Dinosaur dino = MockHelper.createDinosaurMock("T-Rex");

        mockMvc.perform(
                post( "/dinosaur" )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( jsonMapper.writeValueAsString( dino ) ) )
                .andExpect( status().is( HttpStatus.CREATED.value() ) )
                .andExpect( jsonPath( "$.name" ).value( dino.getName() ) )
                .andExpect( jsonPath( "$.species" ).value( dino.getSpecies() ) )
                .andExpect( jsonPath( "$.status" ).value( dino.getStatus().toString() ) );
    }

}
