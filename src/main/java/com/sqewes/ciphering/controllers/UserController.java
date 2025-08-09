package com.sqewes.ciphering.controllers;

import com.example.api.UserApi;
import com.example.model.UserRegistrationRequest;
import com.example.model.UserRegistrationResponse;
import com.sqewes.ciphering.entities.User;
import com.sqewes.ciphering.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final IUserService userService;

    @Override
    public ResponseEntity<UserRegistrationResponse> register(UserRegistrationRequest userRegistrationRequest) {
        try {
            String phoneNumber = userRegistrationRequest.getPhoneNumber();
            String userName = userRegistrationRequest.getUserName();

            if (phoneNumber.isEmpty() || userName.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }

            User user = userService.registerUser(phoneNumber, userName);

            UserRegistrationResponse response = new UserRegistrationResponse();
            response.setMessage("User Registered Successfully");
            response.setUserId(user.getId().toString());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
