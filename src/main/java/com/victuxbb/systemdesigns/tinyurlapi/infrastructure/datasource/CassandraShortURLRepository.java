package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.datasource;

import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.URLKey;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURLRepository;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Repository
public class CassandraShortURLRepository implements ShortURLRepository {

    private final ReactiveCassandraOperations reactiveCassandraOperations;

    @Autowired
    public CassandraShortURLRepository(ReactiveCassandraOperations reactiveCassandraOperations) {
        this.reactiveCassandraOperations = reactiveCassandraOperations;
    }

    @Override
    public Mono<ShortURL> save(ShortURL shortUrl) {
        return reactiveCassandraOperations.insert(new URL(shortUrl))
                .map(URL::toShortURL);
    }

    @Override
    public Mono<Void> delete(URLKey urlKey) {
        return Mono.error(new NotImplementedException());
    }
}
