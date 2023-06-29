package com.example.test.dto;

import com.example.test.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String pw;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.pw = user.getPw();
    }


    public UserResponseDto(Long id, String name, String email, String pw) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pw = pw;
    }
}
