package com.hust.movie_review.controllers;

import com.hust.movie_review.common.data.response.DfResponse;
import com.hust.movie_review.data.response.user.LoginResponse;
import com.hust.movie_review.dto.LoginRequest;
import com.hust.movie_review.service.IUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final IUserService userService;
    private final AuthenticationManager authenticationManager;


    public AuthController(IUserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("login")
    public DfResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return DfResponse.okEntity(userService.login(request, authenticationManager));
    }
}
