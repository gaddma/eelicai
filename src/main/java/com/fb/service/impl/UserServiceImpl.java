package com.fb.service.impl;

import org.springframework.stereotype.Service;

import com.fb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    public String getUserName() {
        return "First Blood";
    }

}
