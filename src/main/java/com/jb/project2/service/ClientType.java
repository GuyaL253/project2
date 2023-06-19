package com.jb.project2.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ClientType {
    ADMINISTRATOR("admin@admin.com", "admin"),
    COMPANY(),
    CUSTOMER();

    private String email;
    private String password;

    public static ClientType getType(String email, String password) {
        for (ClientType clientType : ClientType.values()) {
            if (clientType.getEmail().equals(email) && clientType.getPassword().equals(password)) {
                return clientType;
            }
        }
        return null; // Return null if no matching credentials are found
    }
}