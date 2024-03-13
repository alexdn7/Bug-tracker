package com.BugTracker.Backend.service.UserService;

import com.BugTracker.Backend.model.UserEntity;
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
            UserEntity userEntity = UserMapper.mapToEntity(userDto);
            userEntity.setRegisteredOn(LocalDateTime.now());
            return UserMapper.mapToDto(userRepository.save(userEntity));
        } else {
            throw new IllegalArgumentException("Already exists an user with given email");
        }
    }

    @Override
    public UserDto getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("UserEntity not found"));
        return UserMapper.mapToDto(userEntity);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("UserEntity not found"));
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setRole(userDto.getRole());
        userEntity.setPassword(userDto.getPassword());
        return UserMapper.mapToDto(userEntity);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteUser(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("UserEntity not found"));
        userRepository.delete(userEntity);
    }
}
