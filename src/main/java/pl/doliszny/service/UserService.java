package pl.doliszny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.doliszny.model.User;
import pl.doliszny.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;


    @Override
    public Long countById(Long id) {

        Long users = repository.countById(id);

        return users;
    }

    @Override
    public List<User> findAllOrderByBirthDate(String birth_date) {

        List<User> users = (List<User>) repository.findAllOrderByBirthDate(birth_date);
        return users;
    }

    @Override
    public User findBirthDateByLowestWherePhoneNoIsNotNull(String birth_date) {

        User user = repository.findBirthDateByLowestWherePhoneNoIsNotNull(birth_date);
        return user;
    }
}
