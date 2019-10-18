package pl.doliszny.service;

import pl.doliszny.model.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();
    public User findById(Long id);
}
