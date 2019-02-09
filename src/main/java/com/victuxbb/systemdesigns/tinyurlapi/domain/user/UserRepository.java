package com.victuxbb.systemdesigns.tinyurlapi.domain.user;

import reactor.core.publisher.Mono;

interface UserRepository {
    Mono<User> save(User user);
}
