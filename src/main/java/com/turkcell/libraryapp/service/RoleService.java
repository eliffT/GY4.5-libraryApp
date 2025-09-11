package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.publisher.PublisherForAddDto;
import com.turkcell.libraryapp.dto.publisher.PublisherForGetDto;
import com.turkcell.libraryapp.dto.role.RoleForAddDto;
import com.turkcell.libraryapp.dto.role.RoleForGetDto;
import com.turkcell.libraryapp.entity.Publisher;
import com.turkcell.libraryapp.entity.Role;
import com.turkcell.libraryapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleForGetDto> getAllWithDto() {
        List<Role> roleList = roleRepository.findAll();
        List<RoleForGetDto> roleForGetDtoList = new ArrayList<RoleForGetDto>();
        for(Role role : roleList){
            RoleForGetDto roleForGetDto = new RoleForGetDto();
            //RoleForGetDto.setRole(role.getRole());
            roleForGetDtoList.add(roleForGetDto);
        }
        return roleForGetDtoList;
    }

    public RoleForGetDto addWithDto(RoleForAddDto roleForAddDto){
        Role role = new Role();
        role.setRole(roleForAddDto.getRole());

        Role roleSaved = this.roleRepository.save(role);
        RoleForGetDto roleForGetDto = new RoleForGetDto();
        roleForGetDto.setRole(roleSaved.getRole());

        return roleForGetDto;
    }
}
