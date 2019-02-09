package com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl;

import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.URLKey;
import reactor.core.publisher.Mono;

public interface ShortURLRepository {
    Mono<ShortURL> save(ShortURL url);
    Mono<Void> delete(URLKey urlKey);
}
