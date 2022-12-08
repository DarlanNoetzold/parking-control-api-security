package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.RoleModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class UserDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @NotEmpty
    private List<RoleModel> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }
}
