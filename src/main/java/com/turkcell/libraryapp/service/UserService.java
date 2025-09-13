package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.user.request.UserRequest;
import com.turkcell.libraryapp.dto.user.response.UserResponse;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest request) {
        // DTO - Entity
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        userRepository.save(user);

        // Entity - DTO
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        return response;
    }

    public UserResponse updateUser(Integer id, UserRequest request) {

        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        updateUser.setFirstName(request.getFirstName());
        updateUser.setLastName(request.getLastName());
        updateUser.setEmail(request.getEmail());
        updateUser.setPhone(request.getPhone());
        userRepository.save(updateUser);

        UserResponse response = new UserResponse();
        response.setId(updateUser.getId());
        response.setName(updateUser.getFirstName());
        response.setLastName(updateUser.getLastName());
        response.setEmail(updateUser.getEmail());
        response.setPhone(updateUser.getPhone());
        response.setRole(updateUser.getRole());
        response.setActive(updateUser.getActive());
        response.setCreatedAt(updateUser.getCreatedAt());
        return response;
    }

    public void deleteUser(Integer id) {
       Optional<User> user = userRepository.findById(id);
       if (user.isPresent()) {
           userRepository.deleteById(id);
       }
    }

    public UserResponse getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole());
        response.setActive(user.getActive());
        response.setCreatedAt(user.getCreatedAt());
        //response.setBookReservations(null);
        //response.setLoans(null);
        response.setBookReservations(user.getBookReservations());
        response.setLoans(user.getLoans());
        return response;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();

        for (User user : users) {
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setEmail(user.getEmail());
            response.setPhone(user.getPhone());
            response.setRole(user.getRole());
            response.setActive(user.getActive());
            response.setCreatedAt(user.getCreatedAt());
            userResponseList.add(response);
        }
        return userResponseList;
    }

}
