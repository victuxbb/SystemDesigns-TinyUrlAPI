package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.URLKey;
import com.victuxbb.systemdesigns.tinyurlapi.infrastructure.bootstrap.TinyURLAPIApplication;
import com.victuxbb.systemdesigns.tinyurlapi.infrastructure.datasource.InMemoryKGSRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TinyURLAPIApplication.class)
@AutoConfigureWebTestClient
public class TinyURLControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ObjectMapper objectMapper;

    @SpyBean
    private InMemoryKGSRepository kgsRepository;

    @Test
    public void createTinyURL() throws JsonProcessingException {
        when(kgsRepository.getUniqueKey()).thenReturn(Mono.just(new URLKey("/miau")));
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