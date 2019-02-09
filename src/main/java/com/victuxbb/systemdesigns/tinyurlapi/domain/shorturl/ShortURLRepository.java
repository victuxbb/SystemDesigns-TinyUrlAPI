package com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl;

import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.URLKey;
import reactor.core.publisher.Mono;

public interface ShortURLRepository {
    Mono<ShortUrl> save(ShortUrl url);
    Mono<Void> delete(URLKey urlKey);
}
