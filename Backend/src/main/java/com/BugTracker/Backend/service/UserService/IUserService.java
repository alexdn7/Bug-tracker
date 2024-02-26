package com.BugTracker.Backend.service.UserService;

import com.BugTracker.Backend.model.dto.UserDto;

import java.util.List;

public interface IUserService {

    UserDto addUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto userDto);

    void deleteUser(Long userId);
}
