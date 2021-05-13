package com.example.usermicroserviceproject.service;

import com.example.usermicroserviceproject.domain.UserEntity;
import com.example.usermicroserviceproject.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();
}
