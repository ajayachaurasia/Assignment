package com.basic.synchrony.dto;

import lombok.Data;

/**
 *
 *  DTO class to transfer data or payload between client and server and vice-versa
 *
 * */

@Data
public class LoginDTO {
    private String usernameOrEmail;
    private String password;

}
