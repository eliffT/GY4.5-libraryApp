package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.core.jwt.JwtUtil;
import com.turkcell.libraryapp.dto.auth.request.LoginRequest;
import com.turkcell.libraryapp.dto.auth.request.RegisterRequest;
import com.turkcell.libraryapp.dto.auth.response.LoginResponse;
import com.turkcell.libraryapp.dto.auth.response.RegisteredResponse;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.mapper.UserMapper;
import com.turkcell.libraryapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
    }

    public RegisteredResponse register(RegisterRequest request)
    {
        User user = userMapper.requestToUser(request,passwordEncoder);

        userRepository.save(user);

        RegisteredResponse response = new RegisteredResponse();
        response.setUsername(request.getUsername());
        return response;
    }

    public LoginResponse login(LoginRequest request)
    {
        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Wrong username or password."));

        if(!passwordEncoder.matches(request.getPassword(),user.getPassword()))
            throw new RuntimeException("Wrong username or password.");
        List<String> roles = user
                .getOperationClaims()
                .stream()
                .map(o->o.getName())
                .toList();

        LoginResponse response = new LoginResponse();
        response.setToken(jwtUtil.generateToken(user.getUsername(), roles));
        return response;

    }

    public Boolean validateToken(String token)
    {
        return jwtUtil.validateToken(token);
    }
}