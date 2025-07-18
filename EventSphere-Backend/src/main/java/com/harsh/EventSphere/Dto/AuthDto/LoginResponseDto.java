package com.harsh.EventSphere.Dto.AuthDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LoginResponseDto {

    private String JwtToken;

    private String userName;

    private List<String> roles;

}
