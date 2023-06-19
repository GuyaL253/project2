package com.jb.project2.security;


import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.ErrMsg;
import com.jb.project2.service.ClientType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private Map<UUID, LoginInfo> tokens = new HashMap<>();

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

        tokens.forEach((Token, value) -> System.out.println("Token: " + Token.toString() + ", Value: " + value.getId() + value.getClientType() + value.getTime()));

        return newToken;
    }

    @Override
    public void clearExpiredTokens(LocalDateTime now) {
        tokens.values().removeIf(obj -> obj.getTime().isBefore(LocalDateTime.now().minusMinutes(30)));
        tokens.forEach((key, value) -> System.out.println("Key: " + key.toString() + ", Value: " + value.getTime()));
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

    @Override
    public int getClientId(UUID token) throws CouponSystemException {
        LoginInfo loginInfo = tokens.get(token);
        if (loginInfo != null) {
            return loginInfo.getId();
        }
        throw new CouponSystemException(ErrMsg.RESTRICTED_AREA);
    }
}
