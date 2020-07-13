package com.xmsx24.demo;

public interface UserService {
    Message register(UserBean user);
    Message login(UserBean user);
}
