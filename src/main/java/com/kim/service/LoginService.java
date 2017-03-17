package com.kim.service;

import com.kim.domain.User;
import com.kim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean insert(String id, String password) {
        if(!isExistId(id)) {
            User user = new User();
            user.setId(id);
            user.setPassword(password);
            userRepository.save(user);

            return true;
        }
        return false;
    }

    @Transactional
    public boolean isCorrectIdAndPassword(String id, String password) {
        if(userRepository.findByIdAndPassword(id, password) != null)
            return true;
        return false;
    }

    @Transactional
    public boolean isExistId(String id) {
        if(userRepository.findOneById(id) != null)
            return true;
        return false;
    }
}