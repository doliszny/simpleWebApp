package pl.doliszny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        public ResponseEntity<List<User>> getAllUsers(
                            @RequestParam(defaultValue = "0") Integer pageNo,
                            @RequestParam(defaultValue = "5") Integer pageSize,
                            @RequestParam(defaultValue = "birth_date") String sortBy)
        {
            List<User> list = userService.getAllEmployees(pageNo, pageSize, sortBy);

            return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
        }

    @RequestMapping(value = "/users/sort", produces = "newspoint/csv")
    public User findOldest(String birth_date) {

        return userService.findBirthDateByLowestWherePhoneNoIsNotNull(birth_date);
    }
}
