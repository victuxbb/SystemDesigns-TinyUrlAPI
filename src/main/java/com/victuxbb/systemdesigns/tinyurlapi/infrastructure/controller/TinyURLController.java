package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.controller;

import com.victuxbb.systemdesigns.tinyurlapi.application.CreateShortURL;
import com.victuxbb.systemdesigns.tinyurlapi.application.ShortURLRequest;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURL;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController

public class TinyURLController {

  private final CreateShortURL createShortURL;

  public TinyURLController(CreateShortURL createShortURL) {
    this.createShortURL = createShortURL;
  }

  @PostMapping(path = "/tinyURL")
  public Mono<ShortURL> createTinyURL(@RequestBody CreateTinyURLRequest createTinyURLRequest) {
    return Mono.fromCallable(() -> new ShortURLRequest(createTinyURLRequest.getOriginalURL()))
        .flatMap(createShortURL::create);
  }
}
