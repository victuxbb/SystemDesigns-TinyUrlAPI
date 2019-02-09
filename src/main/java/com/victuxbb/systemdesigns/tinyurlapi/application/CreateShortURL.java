package com.victuxbb.systemdesigns.tinyurlapi.application;

import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURLRepository;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortUrl;
import com.victuxbb.systemdesigns.tinyurlapi.domain.urlkey.KGSRepository;
import reactor.core.publisher.Mono;

public class CreateShortURL {
    private final ShortURLRepository shortURLRepository;
    private final KGSRepository kgsRepository;

    public CreateShortURL(ShortURLRepository shortURLRepository, KGSRepository kgsRepository) {
        this.shortURLRepository = shortURLRepository;
        this.kgsRepository = kgsRepository;
    }

    public Mono<ShortUrl> create(URLRequest urlRequest){

    }
}
