package com.jb.project2.security;


import com.jb.project2.exceptions.CouponSystemException;
import com.jb.project2.exceptions.ErrMsg;
import com.jb.project2.service.ClientType;
import com.jb.project2.utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private Map<UUID, LoginInfo> tokens = new HashMap<>();

    private static Set<UUID> addedTokens = new HashSet<>();

    @Override
    public UUID addClient(int id, ClientType clientType) {
        LoginInfo newLoginInfo = LoginInfo.builder()
                .id(id)
                .clientType(clientType)
                .time(LocalDateTime.now())
                .build();
        UUID existingKey = null;

        // Look for an existing LoginInfo with the same ID
        for (UUID key : tokens.keySet()) {
            LoginInfo loginInfo = tokens.get(key);
            if (loginInfo.getId() == id) {
                // Found an existing LoginInfo with the same ID
                existingKey = key;
                break;
            }
        }

        if (existingKey != null) {
            // Remove the existing LoginInfo with the same ID
            tokens.remove(existingKey);
        }

        // Add the new LoginInfo to the map
        UUID newToken = UUID.randomUUID();
        tokens.put(newToken, newLoginInfo);

        Art.printTokens(tokens);

        return newToken;
    }


    public UUID getToken(LoginInfo loginInfo) throws CouponSystemException {
        // Look for an existing LoginInfo with the same ID
        for (UUID newToken : tokens.keySet()) {
            LoginInfo existingLoginInfo = tokens.get(newToken);
            if (existingLoginInfo.getId() == loginInfo.getId()) {
                // Found an existing LoginInfo with the same ID
                return newToken;
            }
        }
        throw new CouponSystemException(ErrMsg.LOGIN_FAILED);
    }


    @Override
    public boolean isValid(UUID token, ClientType clientType) {
        LoginInfo loginInfo = tokens.get(token);
        if (loginInfo != null) {
            return loginInfo.getClientType().equals(clientType);
        }
        return false;
    }

}
