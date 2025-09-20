package com.dk.service;

import com.dk.model.User;

public interface UserService {
    public User findUserByJwtToken(String jwt) throws Exception;

    public User findByUserByEmail(String email) throws Exception;
}
