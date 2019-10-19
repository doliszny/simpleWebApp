package pl.doliszny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.doliszny.model.User;
import pl.doliszny.service.IUserService;
import pl.doliszny.util.WriteCsvToResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class MyCsvController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/users", produces = "text/csv")
    public void findUsers(HttpServletResponse response) throws IOException {

        List<User> users = (List<User>) userService.findAll();

        WriteCsvToResponse.writeUsers(response.getWriter(), users);
    }

    @RequestMapping(value = "/users/{id}", produces = "text/csv")
    public void findUser(@PathVariable Long id, HttpServletResponse response) throws IOException {

        User user = userService.findById(id);
        WriteCsvToResponse.writeUser(response.getWriter(), user);
    }
}
