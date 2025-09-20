package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.user.request.UserRequest;
import com.turkcell.libraryapp.dto.user.response.UserResponse;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.entity.enumarations.MembershipLevel;
import com.turkcell.libraryapp.mapper.UserMapper;
import com.turkcell.libraryapp.repository.FineRepository;
import com.turkcell.libraryapp.repository.UserRepository;
import com.turkcell.libraryapp.rules.FineBusinessRules;
import com.turkcell.libraryapp.rules.UserBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@Validated
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserBusinessRules  userBusinessRules;
    private final FineRepository fineRepository;

    public UserService(UserRepository userRepository,  UserMapper userMapper,
                       UserBusinessRules userBusinessRules,  FineRepository fineRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userBusinessRules = userBusinessRules;
        this.fineRepository = fineRepository;
    }

    public UserResponse createUser(@Valid UserRequest request) {
        // DTO - Entity
        User user = userMapper.userRequestToUser(request);
        userRepository.save(user);
        // Entity - DTO
        return userMapper.userToUserResponse(user);
    }

    public UserResponse updateUser(Integer id, @Valid UserRequest request) {

        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        updateUser.setFirstName(request.getFirstName());
        updateUser.setLastName(request.getLastName());
        updateUser.setEmail(request.getEmail());
        updateUser.setPhone(request.getPhone());
        userRepository.save(updateUser);

       return userMapper.userToUserResponse(updateUser);
    }

    public void deleteUser(Integer id) {
       Optional<User> user = userRepository.findById(id);
       if (user.isPresent()) {
           userRepository.deleteById(id);
       }
    }

    public UserResponse getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
       return userMapper.userToUserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.userToUserResponseList(users);
    }

    public UserResponse findUserByEmail(String status, String email) {
        User user =  userRepository.findByEmail(email);
        String checkUserStatus = userBusinessRules.checkUserStatus(user);
        if(!checkUserStatus.equalsIgnoreCase(status)){
            throw new NotFoundException("User not found with email: " + email);
        }
        return userMapper.userToUserResponse(user);
    }


    public UserResponse changeUserStatus(Integer id, String value) {
        User user =  userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with id: " + id));
        if(!user.getMembershipLevel().equals(MembershipLevel.valueOf(value))){
            user.setMembershipLevel(MembershipLevel.valueOf(value));
            userRepository.save(user);
        }
        return userMapper.userToUserResponse(user);
    }

//    public UserResponse getUserByIdHasFine(Integer id) {
//        User user = fineRepository.findUserByLoanUserIdAndIsPaidFalse(id);
//       return userMapper.userToUserResponse(user);
//    }
}
