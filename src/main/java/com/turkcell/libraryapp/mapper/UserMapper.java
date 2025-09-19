package com.turkcell.libraryapp.mapper;


import com.turkcell.libraryapp.dto.user.request.UserRequest;
import com.turkcell.libraryapp.dto.user.response.UserResponse;
import com.turkcell.libraryapp.entity.User;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
 //Entity -> Dto
     UserResponse toResponse(User user);
     List<UserResponse> toResponseList(List<User> users);

     //Dto Entity
    User toEntity(UserRequest request);

}
