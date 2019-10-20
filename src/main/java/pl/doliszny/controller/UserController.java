package pl.doliszny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.doliszny.model.User;
import pl.doliszny.service.IUserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/users", produces = "newspoint/csv")
    public Long findUsers(Long id) {

        return userService.countById(id);
    }

    @RequestMapping(value = "/users/odl", produces = "newspoint/csv")
    public List<User> findUser(String birth_date) {

        return userService.findAllOrderByBirthDate(birth_date);
    }

    @RequestMapping(value = "/users/sort", produces = "newspoint/csv")
    public User findOldest(String birth_date) {

        return userService.findBirthDateByLowestWherePhoneNoIsNotNull(birth_date);
    }
}
