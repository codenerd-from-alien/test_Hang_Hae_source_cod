package com.example.test.entity;


import com.example.test.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String pw;

    public User(UserRequestDto requestDto) {
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.pw =requestDto.getPw();
    }


}
