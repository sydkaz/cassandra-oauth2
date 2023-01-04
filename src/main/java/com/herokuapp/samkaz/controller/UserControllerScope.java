package com.herokuapp.samkaz.controller;


import com.herokuapp.samkaz.dto.ApiResponse;
import com.herokuapp.samkaz.model.User;
import com.herokuapp.samkaz.service.UserService;
import com.herokuapp.samkaz.util.Meta;
import com.herokuapp.samkaz.util.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
@Slf4j
@RequestMapping
@RestController
public class UserControllerScope {

    @Autowired
    private UserService userService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @PreAuthorize("#oauth2.hasScope('trust')")
    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @GetMapping
    @PreAuthorize("#oauth2.hasScope('server')")
    public ApiResponse<List> getAllUsers() {
        List<User> users = userService.getAllUsers();
        ApiResponse<List> response = new ApiResponse<>();
        List<UserDetail> userList = users.stream().map(user ->
                dozerBeanMapper.map(user, UserDetail.class)).collect(Collectors.toList());
        response.setData(userList);
        response.setMessage("Users list");
        response.setStatus(new Meta(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()));
        return response;

    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @PostMapping("/signUpUser")
    public ApiResponse<UserDetail> signUpUser(@RequestBody UserDetail userDetail) {

        User user = dozerBeanMapper.map(userDetail, User.class);
        userService.registerUser(user);
        ApiResponse<UserDetail> response = new ApiResponse<>();
        response.setData(dozerBeanMapper.map(user, UserDetail.class));
        response.setMessage("User sign up successfully");
        response.setStatus(new Meta(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()));
        return response;

    }


    @PreAuthorize("#oauth2.hasScope('server')")
    @PostMapping(value = "/getUser")
    public UserDetail getUser(@NotNull @RequestBody String userName) {
        User user = userService.getUserByUserName(userName);
        return dozerBeanMapper.map(user, UserDetail.class);

    }


}
