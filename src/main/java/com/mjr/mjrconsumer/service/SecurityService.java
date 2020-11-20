package com.mjr.mjrconsumer.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
