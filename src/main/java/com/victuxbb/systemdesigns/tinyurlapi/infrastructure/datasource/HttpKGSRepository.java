package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.datasource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.KGSRepository;
import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.URLKey;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Repository
@Primary
public class HttpKGSRepository implements KGSRepository {
  private final RestTemplate restTemplate;

  public HttpKGSRepository() {
    this.restTemplate = new RestTemplate();
  }

  @Override public Mono<URLKey> getUniqueKey() {
    return Mono.fromCallable(
        () -> restTemplate.postForEntity(
            "http://localhost:8080/keys_request",
            new HttpEntity<>(new KGSRequest(1)),
            String[].class
        )
    )
        .map(HttpEntity::getBody)
        .map(strings -> new URLKey(strings[0]));
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private class KGSRequest {
    @JsonProperty("quantity")
    private Integer quantity;

    private KGSRequest(Integer quantity) {
      this.quantity = quantity;
    }
  }
}
