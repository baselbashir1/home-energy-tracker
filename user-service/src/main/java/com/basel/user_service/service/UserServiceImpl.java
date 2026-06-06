package com.basel.user_service.service;

import com.basel.user_service.dto.UserDto;
import com.basel.user_service.entity.User;
import com.basel.user_service.mapper.UserMapper;
import com.basel.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("Creating user: {}", userDto);

        User user = userRepository.save(userMapper.mapToUser(userDto));

        return userMapper.mapToUserDto(user);
    }
}