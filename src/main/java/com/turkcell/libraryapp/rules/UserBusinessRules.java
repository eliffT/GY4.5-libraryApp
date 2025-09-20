package com.turkcell.libraryapp.rules;

import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.entity.enumarations.MembershipLevel;
import com.turkcell.libraryapp.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class UserBusinessRules {

    private final UserRepository userRepository;

    public UserBusinessRules(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Üye aktif mi cezalı mı?
    public String checkUserStatus(User user){
        if(user.getMembershipLevel() == MembershipLevel.BANNED){
            throw new NotFoundException("Member is banned");
        }
        return "ACTIVE";
    }



}
