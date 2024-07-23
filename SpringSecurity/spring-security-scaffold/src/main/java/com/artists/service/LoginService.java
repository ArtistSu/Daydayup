package com.artists.service;

import com.artists.domain.ResponseResult;
import com.artists.domain.User;

public interface LoginService {
    public ResponseResult login(User user);
}
