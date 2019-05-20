package com.olenaznak.services;

import com.olenaznak.models.User;

public interface UserService {
    User getUser(String login);

}
