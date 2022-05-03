package com.hust.movie_review.controllers;

import com.hust.movie_review.common.data.response.DfResponse;
import com.hust.movie_review.data.request.user.CreateUserRequest;
import com.hust.movie_review.data.response.user.UserInfoResponse;
import com.hust.movie_review.service.IUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/admin/user/")
public class AdminController {
    private final IUserService userService;


    public AdminController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public DfResponse<UserInfoResponse> createUser(@Valid @RequestBody CreateUserRequest request){
        return DfResponse.okEntity(userService.createUser(request));
    }
}
