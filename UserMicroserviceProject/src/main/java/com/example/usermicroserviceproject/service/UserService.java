package com.example.usermicroserviceproject.service;

import com.example.usermicroserviceproject.domain.UserEntity;
import com.example.usermicroserviceproject.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailsByEmail(String username);
}

