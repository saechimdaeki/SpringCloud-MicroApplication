package com.example.usermicroserviceproject.service;

import com.example.usermicroserviceproject.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
