package pl.doliszny.service;

import pl.doliszny.model.User;

import java.util.List;

public interface IUserService {

    Long countById(Long Id);

    List<User> findAllOrderByBirthDate(String birth_date);

    User findBirthDateByLowestWherePhoneNoIsNotNull(String birth_date);

}
