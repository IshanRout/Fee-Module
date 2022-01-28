package com.cutm.erp.fees.service;

import com.cutm.erp.fees.entity.User;
import com.cutm.erp.fees.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getUserByUserId(Integer userId) {
        return userRepository.getById(userId);
    }

}