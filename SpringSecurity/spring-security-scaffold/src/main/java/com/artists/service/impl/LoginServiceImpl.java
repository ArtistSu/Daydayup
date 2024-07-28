package com.artists.service.impl;

import com.artists.domain.LoginUser;
import com.artists.domain.ResponseResult;
import com.artists.domain.User;
import com.artists.service.LoginService;
import com.artists.utils.JwtUtil;
import com.artists.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        // 1. AuthenticationManager authenticate()
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("Login failed please double check!");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        // 2. Put user information in redis
        redisCache.setCacheObject("login:" + userId, loginUser);
        return new ResponseResult(200, "Login Successfully", map);
    }

    @Override
    public ResponseResult logout() {
        // 1.Get id in SecurityContextHolder
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();

        // 2.Remove user information in redis
        redisCache.deleteObject("login:" + userId);

        return new ResponseResult(200, "Logout successfully");
    }
}
