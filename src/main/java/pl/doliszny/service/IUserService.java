package pl.doliszny.service;

import org.springframework.data.domain.Page;
import pl.doliszny.model.User;

import java.awt.print.Pageable;
import java.util.List;

public interface IUserService {

    Long countById(Long id);

    List<User> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);

    User findBirthDateByLowestWherePhoneNoIsNotNull(String birth_date);

}
