package com.example.test.service;

import com.example.test.dto.UserRequestDto;
import com.example.test.dto.UserResponseDto;
import com.example.test.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserService {


    private final UserRepository userRepository;
    public UserService(JdbcTemplate jdbcTemplate) {
        this.userRepository = new UserRepository(jdbcTemplate);
    }


    public List<UserResponseDto> getUsers() {
        return userRepository.findAll();

    }

    public UserResponseDto getOne(Long id, UserRequestDto requestDto) {
        return userRepository.finOne(id, requestDto);
    }


}
