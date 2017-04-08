package com.example.service.user;

import com.example.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getList();

}