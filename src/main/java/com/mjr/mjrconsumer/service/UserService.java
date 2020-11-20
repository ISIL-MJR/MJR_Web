package com.mjr.mjrconsumer.service;

import com.mjr.mjrconsumer.model.User;


public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
