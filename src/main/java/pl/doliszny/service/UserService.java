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
    public List<User> findAll() {

        List<User> users = (List<User>) repository.findAll();

        return users;
    }

    @Override
    public User findById(Long id) {

        User user = repository.findOne(id);
        return user;
    }
}
