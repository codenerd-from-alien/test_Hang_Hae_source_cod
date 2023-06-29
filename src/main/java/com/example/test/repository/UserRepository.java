package com.example.test.repository;

import com.example.test.dto.UserRequestDto;
import com.example.test.dto.UserResponseDto;
import com.example.test.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    public UserRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<UserResponseDto> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new RowMapper<UserResponseDto>() {
            @Override
            public UserResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String pw = rs.getString("pw");
                return new UserResponseDto(id, name, email, pw);
            }
        });
    }
    public UserResponseDto finOne(Long id, UserRequestDto requestDto) {

        User user = findById(id);
        if(user !=null){
            return new UserResponseDto(user);
        }else {
            throw new NullPointerException("null point exception!");
        }
    }








    private User findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPw(resultSet.getString("pw"));
                return user;
            } else {
                return null;
            }
        }, id);
    }


}
