package com.herokuapp.samkaz.controller;

import com.herokuapp.samkaz.dto.ApiResponse;
import com.herokuapp.samkaz.dto.UserDTO;
import com.herokuapp.samkaz.model.User;
import com.herokuapp.samkaz.service.UserService;
import com.herokuapp.samkaz.util.Meta;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    public ApiResponse<List> getAllUsers() {
        List<User> users = userService.getAllUsers();
        ApiResponse<List> response = new ApiResponse<>();
        List<UserDTO> userList = users.stream().map(user ->
                dozerBeanMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        response.setData(userList);
        response.setMessage("Users list");
        response.setStatus(new Meta(HttpStatus.OK));
        return response;

    }

    @PostMapping("/signup")
    public ApiResponse<UserDTO> signUpUser(@RequestBody UserDTO dto) {

        User user = dozerBeanMapper.map(dto, User.class);
        userService.registerUser(user);
        ApiResponse<UserDTO> response = new ApiResponse<>();
        response.setData(dozerBeanMapper.map(user, UserDTO.class));
        response.setMessage("User sign up successfully");
        response.setStatus(new Meta(HttpStatus.OK));
        return response;

    }

    @GetMapping(value = "/me")
    public ApiResponse<UserDTO> currentUserName(Principal principal) {
        String userName =   principal.getName();
        User user = userService.getUserByUserName(userName);
        ApiResponse<UserDTO> response = new ApiResponse<>();
        response.setData(dozerBeanMapper.map(user, UserDTO.class));
        response.setMessage("User detail");
        response.setStatus(new Meta(HttpStatus.OK));
        return response;
    }


}
