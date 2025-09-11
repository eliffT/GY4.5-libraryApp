package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.publisher.PublisherForAddDto;
import com.turkcell.libraryapp.dto.publisher.PublisherForGetDto;
import com.turkcell.libraryapp.dto.role.RoleForAddDto;
import com.turkcell.libraryapp.dto.role.RoleForGetDto;
import com.turkcell.libraryapp.service.PublisherService;
import com.turkcell.libraryapp.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class RolesController {

    private RoleService roleService;

    public RolesController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping()
    public List<RoleForGetDto> getAllWithDto(){
        return roleService.getAllWithDto();
    }
    @PostMapping()
    public RoleForGetDto addBookWithDto(@RequestBody RoleForAddDto roleForAddDto){
        return roleService.addWithDto(roleForAddDto);
    }
    @GetMapping("/{id}")
    public RoleForGetDto getByIdWithDto(@PathVariable Integer id){
        return roleService.getByIdWithDto(id);
    }
}
