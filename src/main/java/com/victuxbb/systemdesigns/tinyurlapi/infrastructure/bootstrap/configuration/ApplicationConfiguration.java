package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.bootstrap.configuration;

import com.victuxbb.systemdesigns.tinyurlapi.application.CreateShortURL;
import com.victuxbb.systemdesigns.tinyurlapi.domain.kgs.KGSRepository;
import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURLRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CreateShortURL createShortURL(ShortURLRepository shortURLRepository, KGSRepository kgsRepository) {
        return new CreateShortURL(shortURLRepository, kgsRepository);
    }
}
