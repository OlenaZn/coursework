package com.olenaznak.dao;

import com.olenaznak.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private List<User> userList;

    public UserDao(List<User> userList) {
        this.userList = userList;
    }

    public UserDao() {
        userList = new ArrayList<>();
    }

    public void addSUser(User user) {
        userList.add(user);
    }

    public void deleteStudent(User student) {
        userList.remove(student);
    }
}
