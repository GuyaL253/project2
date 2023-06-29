package com.jb.project2.security;


import com.jb.project2.exceptions.CouponSystemException;
import com.jb.project2.service.ClientType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface TokenService {
    UUID addClient(int id, ClientType clientType);

    boolean isValid(UUID token, ClientType clientType);

    UUID getToken(LoginInfo loginInfo) throws CouponSystemException;
}
