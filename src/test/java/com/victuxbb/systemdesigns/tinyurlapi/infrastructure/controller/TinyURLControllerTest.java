package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.victuxbb.systemdesigns.tinyurlapi.infrastructure.bootstrap.TinyURLAPIApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TinyURLAPIApplication.class)
@AutoConfigureWebTestClient
public class TinyURLControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createTinyURL() throws JsonProcessingException {
        webTestClient
                .post()
                .uri("/tinyURL")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(objectMapper.writeValueAsString(new CreateTinyURLRequest("/yupiiiii")))
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("$.hash", "/miau");

    }
}