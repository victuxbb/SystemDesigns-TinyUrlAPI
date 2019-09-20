package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.datasource;

import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURL;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

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

  @Override public Mono<ShortURL> find(String key) {
    //MapId id = id("hash", key);
    return reactiveCassandraOperations.selectOneById(key, URL.class)
        .map(URL::toShortURL);
  }
}
