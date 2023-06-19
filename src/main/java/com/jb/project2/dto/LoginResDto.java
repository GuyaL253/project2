package com.jb.project2.dto;

import com.jb.project2.service.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResDto {
    private UUID token;
    private ClientType clientType;
    private int id;
}