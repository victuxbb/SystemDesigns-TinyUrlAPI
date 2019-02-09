package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.datasource;

import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.KGSRepository;
import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.URLKey;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class InMemoryKGSRepository implements KGSRepository {
    @Override
    public Mono<URLKey> getUniqueKey() {
        return Mono.just(new URLKey("/miau"));
    }
}
