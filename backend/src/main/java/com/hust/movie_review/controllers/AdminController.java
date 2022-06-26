package com.hust.movie_review.controllers;

import com.hust.movie_review.data.request.user.UpdateUserRequest;
import com.hust.movie_review.data.response.DfResponse;
import com.hust.movie_review.data.request.user.CreateUserRequest;
import com.hust.movie_review.data.response.user.UserInfoResponse;
import com.hust.movie_review.service.template.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/admin/user/")
public class AdminController {
    private final IUserService userService;

    public AdminController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public DfResponse<UserInfoResponse> createUser(@RequestBody @Valid CreateUserRequest request){
        return DfResponse.okEntity(userService.createUser(request));
    }

    @PutMapping(value = "/update")
    public DfResponse<UserInfoResponse> update(@RequestBody @Valid UpdateUserRequest request){
        return DfResponse.okEntity(userService.updateUser(request));
    }

    @DeleteMapping(value = "/delete/{id}")
    public DfResponse<String> delete(@PathVariable Integer id){
        return DfResponse.okEntity(userService.deleteUser(id));
    }
}
