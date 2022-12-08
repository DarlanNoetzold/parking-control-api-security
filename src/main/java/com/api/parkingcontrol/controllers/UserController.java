package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.UserDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
    final UserService userService;
    final PasswordEncoder encoder;


    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.encoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
