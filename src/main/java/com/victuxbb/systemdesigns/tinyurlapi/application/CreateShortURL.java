package com.victuxbb.systemdesigns.tinyurlapi.application;

import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURLRepository;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURL;
import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.KGSRepository;
import reactor.core.publisher.Mono;

public class CreateShortURL {
    private final ShortURLRepository shortURLRepository;
    private final KGSRepository kgsRepository;

    public CreateShortURL(ShortURLRepository shortURLRepository, KGSRepository kgsRepository) {
        this.shortURLRepository = shortURLRepository;
        this.kgsRepository = kgsRepository;
    }

    public Mono<ShortURL> create(ShortURLRequest shortUrlRequest) {
        return kgsRepository.getUniqueKey()
                .flatMap(urlKey -> shortURLRepository.save(new ShortURL(urlKey.getKey(), shortUrlRequest.getOriginalURL())));
    }
}
