package com.hust.movie_review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
