package com.victuxbb.systemdesigns.tinyurlapi.application;

import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURL;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURLRepository;
import reactor.core.publisher.Mono;

public class RedirectShortURL {
  private final ShortURLRepository shortURLRepository;

  public RedirectShortURL(ShortURLRepository shortURLRepository) {
    this.shortURLRepository = shortURLRepository;
  }

  public Mono<ShortURL> redirect(String key) {
    return this.shortURLRepository.find(key);
  }
}
