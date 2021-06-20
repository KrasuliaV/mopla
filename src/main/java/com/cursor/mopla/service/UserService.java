package com.cursor.mopla.service;

import com.cursor.mopla.entities.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findByName(String name);


}
