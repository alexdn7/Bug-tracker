package com.BugTracker.Backend.service.UserService;

import com.BugTracker.Backend.model.User;
import com.BugTracker.Backend.model.dto.UserDto;
import com.BugTracker.Backend.model.mapper.UserMapper;
import com.BugTracker.Backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto addUser(UserDto userDto) {
        if(userRepository.findByEmail(userDto.getEmail()) == null) {
            User user = UserMapper.mapToEntity(userDto);
            user.setRegisteredOn(LocalDateTime.now());
            return UserMapper.mapToDto(userRepository.save(user));
        } else {
            throw new IllegalArgumentException("Already exists an user with given email");
        }
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return UserMapper.mapToDto(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setPasswordHash(userDto.getPasswordHash());
        return UserMapper.mapToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
