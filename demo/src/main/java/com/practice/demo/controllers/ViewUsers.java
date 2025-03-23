package com.practice.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.practice.demo.Pojo.User;
import com.practice.demo.services.UserCrud;

@Controller
@RequestMapping("viewusers")
public class ViewUsers {
    UserCrud userCrud;

    @Autowired
    public ViewUsers(UserCrud userCrud) {
        this.userCrud = userCrud;
    }

    @GetMapping("")
    public String getUsers(Model model) {
        User[] u = this.userCrud.getUsers();
        List<User> users = new ArrayList<>(Arrays.asList(u));
        model.addAttribute("users", users);

        return "users";
    }
}
