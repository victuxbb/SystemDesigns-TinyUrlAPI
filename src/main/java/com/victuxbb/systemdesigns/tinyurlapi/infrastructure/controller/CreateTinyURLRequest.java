package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTinyURLRequest {
  private final String originalURL;

  @JsonCreator
  public CreateTinyURLRequest(
          @JsonProperty("originalURL") String originalURL
  ) {
    this.originalURL = originalURL;
  }

  public String getOriginalURL() {
    return originalURL;
  }
}
