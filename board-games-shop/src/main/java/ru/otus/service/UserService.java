package ru.otus.service;

import ru.otus.data.entity.User;

public interface UserService {
    void addNewUser(String name, String login, String pass);
    User getUser(String login, String pass);
}
