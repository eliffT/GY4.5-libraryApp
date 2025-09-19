package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.user.request.UserRequest;
import com.turkcell.libraryapp.dto.user.response.UserResponse;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.mapper.UserMapper;
import com.turkcell.libraryapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(UserRequest request) {

        User user = userMapper.toEntity(request);
        User saved = userRepository.save(user);
        return userMapper.toResponse(saved);

    }

    public UserResponse updateUser(Integer id, UserRequest request) {

        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        //update
        updateUser.setFirstName(request.getFirstName());
        updateUser.setLastName(request.getLastName());
        updateUser.setEmail(request.getEmail());
        updateUser.setPhone(request.getPhone());

        User updated = userRepository.save(updateUser);
        return userMapper.toResponse(updated);

    }

    public void deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
    }

    public UserResponse getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return userMapper.toResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
       return userMapper.toResponseList(users);
    }

    public List<UserResponse> getFinesByUserId(Integer id, boolean isPaid)
    {
       List<User> userList = userRepository.findUsersWithUnpaidFines(id, isPaid);
       return userMapper.toResponseList(userList);

    }


}