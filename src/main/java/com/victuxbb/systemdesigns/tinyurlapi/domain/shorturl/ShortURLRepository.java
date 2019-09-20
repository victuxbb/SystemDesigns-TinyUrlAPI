package com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl;

import reactor.core.publisher.Mono;

public interface ShortURLRepository {
  Mono<ShortURL> save(ShortURL url);

  Mono<ShortURL> find(String key);
}
