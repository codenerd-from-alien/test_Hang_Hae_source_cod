package com.example.test.controller;


import com.example.test.dto.UserRequestDto;
import com.example.test.dto.UserResponseDto;
import com.example.test.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    public UserController(JdbcTemplate jdbcTemplate) {
        this.userService = new UserService(jdbcTemplate);
    }

    @GetMapping("/user")//전체 목록 조회
    public List<UserResponseDto> getUserList(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserResponseDto getUserInfo(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        return userService.getOne(id, requestDto);
    }


}
