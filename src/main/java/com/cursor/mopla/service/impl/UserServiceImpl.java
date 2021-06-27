package com.cursor.mopla.service.impl;

import com.cursor.mopla.entities.User;
import com.cursor.mopla.repositories.UserRepository;
import com.cursor.mopla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }
}
