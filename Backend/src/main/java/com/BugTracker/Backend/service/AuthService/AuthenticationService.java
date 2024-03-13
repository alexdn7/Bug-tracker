package com.BugTracker.Backend.service.AuthService;

import com.BugTracker.Backend.config.AuthenticationResponse;
import com.BugTracker.Backend.config.JwtService;
import com.BugTracker.Backend.enums.Role;
import com.BugTracker.Backend.model.UserEntity;
import com.BugTracker.Backend.model.dto.LoginDto;
import com.BugTracker.Backend.model.dto.UserDto;
import com.BugTracker.Backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UserDto userDto) throws Exception {
        if(userRepository.existsByEmail(userDto.getEmail())) {
            throw new Exception("User already exists");
        }

        UserEntity userEntity = UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .role(Role.Admin)
                .password(passwordEncoder.encode(userDto.getPassword()))
                .registeredOn(LocalDateTime.now())
                .build();

        UserEntity savedUser = userRepository.save(userEntity);
        String fullName = savedUser.getFirstName() + " " + savedUser.getLastName();
        String token = jwtService.generateToken(userEntity);
        return AuthenticationResponse.builder()
                .userId(savedUser.getUserId())
                .fullName(fullName)
                .role(savedUser.getRole().name())
                .email(savedUser.getEmail())
                .token(token)
                .build();
    }

    public AuthenticationResponse login(LoginDto loginDto) {
        UserEntity userEntity = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String fullName = userEntity.getFirstName() + " " + userEntity.getLastName();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        String token = jwtService.generateToken(userEntity);
        return AuthenticationResponse.builder()
                .userId(userEntity.getUserId())
                .fullName(fullName)
                .role(userEntity.getRole().name())
                .email(userEntity.getEmail())
                .token(token)
                .build();
    }
}
