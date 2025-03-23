package com.practice.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.practice.demo.Pojo.User;

@Service
public class UserCrud {
    Map<Long, User> map;

    public UserCrud() {
        this.map = new HashMap<>();
    }

    public User[] getUsers() {
        User[] users = this.map.values().toArray(new User[0]);
        return users;
    }

    public void createUser(User user) {
        this.map.put(user.getProfileId(), user);
    }

    public User getUser(Long id) {
        return this.map.get(id);
    }

    public void deleteUser(Long id) {
        this.map.remove(id);
    }

    public void updateUser(User user) {
        if (this.map.containsKey(user.getProfileId())) {
            this.map.put(user.getProfileId(), user);
        } else {
            System.out.println("No record found");
        }
    }
}
