package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.controller;

import com.victuxbb.systemdesigns.tinyurlapi.application.CreateShortURL;
import com.victuxbb.systemdesigns.tinyurlapi.application.RedirectShortURL;
import com.victuxbb.systemdesigns.tinyurlapi.application.ShortURLRequest;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURL;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController

public class TinyURLController {

  private final CreateShortURL createShortURL;
  private final RedirectShortURL redirectShortURL;

  public TinyURLController(CreateShortURL createShortURL,
      RedirectShortURL redirectShortURL) {
    this.createShortURL = createShortURL;
    this.redirectShortURL = redirectShortURL;
  }

  @PostMapping(path = "/tinyURL")
  public Mono<ShortURL> createTinyURL(@RequestBody CreateTinyURLRequest createTinyURLRequest) {
    return Mono.fromCallable(() -> new ShortURLRequest(createTinyURLRequest.getOriginalURL()))
        .flatMap(createShortURL::create);
  }

  @RequestMapping(value = "/{key}", method = RequestMethod.GET)
  public Mono<ResponseEntity<Void>> redirect(@PathVariable("key") String key) {
    return redirectShortURL.redirect(key)
        .flatMap(shortURL -> Mono.fromCallable(() -> new URI(shortURL.getOriginalURL())))
        .map(uri -> ResponseEntity
            .status(HttpStatus.SEE_OTHER)
            .location(uri).build());
  }
}
