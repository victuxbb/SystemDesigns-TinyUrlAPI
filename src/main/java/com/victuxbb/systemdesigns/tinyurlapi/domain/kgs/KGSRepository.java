package com.victuxbb.systemdesigns.tinyurlapi.domain.kgs;

import reactor.core.publisher.Mono;

public interface KGSRepository {
    Mono<URLKey> getUniqueKey();
}
