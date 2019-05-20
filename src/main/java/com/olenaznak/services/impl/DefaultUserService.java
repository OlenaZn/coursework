package com.olenaznak.services.impl;

import com.olenaznak.models.User;
import com.olenaznak.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserService implements UserService {
    @Override
    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return user;
    }
}
