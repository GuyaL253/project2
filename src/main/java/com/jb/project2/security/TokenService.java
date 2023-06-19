package com.jb.project2.security;


import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.service.ClientType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface TokenService {
    UUID addClient(int id, ClientType clientType);

    void clearExpiredTokens(LocalDateTime now);

    boolean isValid(UUID token, ClientType clientType);

    int getClientId(UUID token) throws CouponSystemException;

    UUID getToken(LoginInfo loginInfo) throws CouponSystemException;
}
