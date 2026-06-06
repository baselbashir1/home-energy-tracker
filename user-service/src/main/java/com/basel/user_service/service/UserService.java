package com.basel.user_service.service;

import com.basel.user_service.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}