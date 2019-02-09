package com.victuxbb.systemdesigns.tinyurlapi.domain.urlkey;

import reactor.core.publisher.Mono;

public interface KGSRepository {
    Mono<URLKey> getUniqueKey();
}
