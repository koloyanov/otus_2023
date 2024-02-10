package ru.otus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.otus.data.entity.User;
import ru.otus.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/new-user", method = RequestMethod.POST)
    public void addNewUser(String name, String login, String pass) {
        userService.addNewUser(name, login, pass);
    }

    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    public User getUser(String login, String pass) {
        return userService.getUser(login, pass);
    }
}
