package com.aton.backend.service;

import com.aton.backend.dto.auth.TokenResponse;
import com.aton.backend.entity.RefreshTokenEntity;
import com.aton.backend.entity.User;
import com.aton.backend.repository.RefreshRepository;
import com.aton.backend.utils.AuthProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionService {
    private final AuthProperties authProperties;
    private final JwtService jwtService;
    private final RefreshRepository refreshRepository;
    @Transactional
    public TokenResponse newSession(User user) {
        RefreshTokenEntity tokenEntity = new RefreshTokenEntity()
                .setRefreshValue(RandomStringGenerator.generateRandomString(authProperties.getRefreshLength()))
                .setUser(user)
                .setValidUntil(LocalDateTime.now().plusDays(authProperties.getRefreshLifespan()));
        tokenEntity = refreshRepository.save(tokenEntity);

        String jwt = jwtService.createJwt(user.getUserId(),
                List.of(user.getUserRole().name()));

        return new TokenResponse()
                .setUserid(user.getUserId())
                .setRefresh(tokenEntity.getRefreshValue())
                .setJwt(jwt);
    }
//
//    @Transactional(noRollbackFor = {RefreshExpiredException.class})
//    public TokenResponse refresh(String token) {
//        RefreshTokenEntity tokenEntity = refreshRepository.findById(token)
//                .orElseThrow(RefreshExpiredException::new);
//        log.info("refreshing for " + tokenEntity.getAccountEntity().getUserId());
//        if (tokenEntity.getValidUntil().isBefore(LocalDateTime.now()))
//            throw new RefreshExpiredException();
//        if (tokenEntity.getUsedAt() != null) {
//            removeAllActiveSessions(tokenEntity.getAccountEntity().getUserId());
//            throw new RefreshExpiredException();
//        }
//        tokenEntity.setUsedAt(LocalDateTime.now());
//        refreshRepository.save(tokenEntity);
//        return newSession(tokenEntity.getAccountEntity(), tokenEntity.isTelegramSession());
//    }
}
