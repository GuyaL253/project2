package com.jb.project2.dto;

import com.jb.project2.service.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginReqDto {
    private String email;
    private String password;
    private ClientType clientType;
}
