package com.BugTracker.Backend.service.AuthService;

import com.BugTracker.Backend.config.AuthenticationResponse;
import com.BugTracker.Backend.config.JwtService;
import com.BugTracker.Backend.enums.Role;
import com.BugTracker.Backend.model.UserEntity;
import com.BugTracker.Backend.model.dto.LoginDto;
import com.BugTracker.Backend.model.dto.UserDto;
import com.BugTracker.Backend.model.mapper.UserMapper;
import com.BugTracker.Backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public AuthenticationResponse register(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .registeredOn(LocalDateTime.now())
                .build();

        UserEntity savedUser = userRepository.save(userEntity);
        String token = jwtService.generateToken(userEntity);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse login(LoginDto loginDto) {
        System.out.println(loginDto.getPassword());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        System.out.println(loginDto.getPassword());
         UserEntity userEntity = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow();
        System.out.println(loginDto.getPassword());
        String token = jwtService.generateToken(userEntity);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
