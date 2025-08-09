package com.sqewes.ciphering.services;

import com.sqewes.ciphering.entities.User;

public interface IUserService {
    User registerUser(String phoneNumber, String userName);
}
