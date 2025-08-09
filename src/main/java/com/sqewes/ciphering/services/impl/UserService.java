package com.sqewes.ciphering.services.impl;

import com.sqewes.ciphering.entities.User;
import com.sqewes.ciphering.repositories.UserRepository;
import com.sqewes.ciphering.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(String phoneNumber, String userName) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseGet(() -> {
                    User user = new User();
                    user.setPhoneNumber(phoneNumber);
                    user.setUserName(userName);
                    return userRepository.save(user);
                });
    }
}
