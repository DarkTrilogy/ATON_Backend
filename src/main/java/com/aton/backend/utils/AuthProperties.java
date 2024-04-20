package com.aton.backend.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class AuthProperties {
    @Value("${auth-params.jwt.lifespan-seconds}")
    private long jwtLifespan;
    @Value("${auth-params.refresh.lifespan-days}")
    private long refreshLifespan;
    @Value("${auth-params.refresh.length}")
    private int refreshLength;
}
