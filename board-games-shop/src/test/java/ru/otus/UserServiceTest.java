package ru.otus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.data.entity.User;
import ru.otus.data.repository.UserRepository;
import ru.otus.service.UserService;
import ru.otus.service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository repository;

    @Test
    public void loginExistsExceptionTest() {
        String name = "name";
        String login = "login";
        String pass = "pass";

        User user = new User(1L, name, login, pass);

        when(repository.findFirstUserByLogin(login)).thenReturn(user);

        Throwable throwable = assertThrows(RuntimeException.class, () -> userService.addNewUser(name, login, pass));
        assertEquals("User with this login is already exist", throwable.getMessage());
    }


}
