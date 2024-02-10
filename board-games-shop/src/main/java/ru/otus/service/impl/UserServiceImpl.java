package ru.otus.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.data.entity.User;
import ru.otus.data.repository.UserRepository;
import ru.otus.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public void addNewUser(String name, String login, String pass) {
        User user = repository.findFirstUserByLogin(login);
        if (user == null) {
            user = new User();
            user.setName(name);
            user.setLogin(login);
            user.setPass(pass);;
            repository.save(user);
        } else {
            throw new RuntimeException("User with this login is already exist");
        }
    }

    @Override
    public User getUser(String login, String pass) {
        User user = repository.findFirstUserByLogin(login);
        if (user != null && user.getPass().equals(pass)) {
            return user;
        }
        throw new RuntimeException("Login or Pass is incorrect");
    }
}
