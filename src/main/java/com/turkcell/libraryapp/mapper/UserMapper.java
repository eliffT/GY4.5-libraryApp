package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.auth.request.RegisterRequest;
import com.turkcell.libraryapp.dto.user.request.UserRequest;
import com.turkcell.libraryapp.dto.user.response.UserResponse;
import com.turkcell.libraryapp.entity.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse userToUserResponse(User user);
    User userRequestToUser(UserRequest userRequest);
    List<UserResponse> userToUserResponseList(List<User> users);
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.getPassword()))")
    User requestToUser(RegisterRequest request, @Context PasswordEncoder passwordEncoder);
}
