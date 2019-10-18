package pl.doliszny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.doliszny.model.User;
import pl.doliszny.service.IUserService;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/users")
    public List<User> findCities() {

        return userService.findAll();
    }

    @RequestMapping("/users/{userId}")
    public User findUser(@PathVariable Long userId) {

        return userService.findById(userId);
    }
}