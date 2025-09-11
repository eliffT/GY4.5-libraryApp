package com.turkcell.libraryapp.dto.role;

public class RoleForAddDto {

    private Integer id;

    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RoleForAddDto(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleForAddDto() {
    }
}
