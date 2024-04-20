package com.aton.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.aton.backend.utils.AuthProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static com.aton.backend.utils.Constants.ISSUER;


@Service
@Slf4j
@RequiredArgsConstructor
public class JwtService {
    private final KeyService keyService;
    private final AuthProperties authProperties;

    public String createJwt(int userid, List<String> roles) {
        Algorithm algorithm = Algorithm.RSA256(
                keyService.getPublicKey(), keyService.getPrivateKey());
        return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(Instant.now())
                .withClaim("userid", userid)
                .withClaim("roles", roles)
                .withExpiresAt(Instant.now().plusSeconds(authProperties.getJwtLifespan()))
                .sign(algorithm);
    }
}
