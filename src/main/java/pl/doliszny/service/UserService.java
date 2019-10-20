package pl.doliszny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.doliszny.model.User;
import pl.doliszny.repository.UserListRepository;
import pl.doliszny.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserListRepository listRepository;


    @Override
    public Long countById(Long id) {

        Long users = repository.countById(id);

        return users;
    }

    @Override
//    public List<User> findAllOrderByBirthDate(Integer pageNo, Integer pageSize, String sortBy) {
//
//        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//        Page<User> users = (List<User>) listRepository.findAllOrderByBirthDate(birth_date, 5);
//        return users;
//    }

     public List<User> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
        {
            Pageable paging = new PageRequest(pageNo, pageSize, new Sort(sortBy));

            Page<User> pagedResult = listRepository.findAll(paging);

            if(pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return new ArrayList<User>();
            }
        }

    @Override
    public User findBirthDateByLowestWherePhoneNoIsNotNull(String birth_date) {

        User user = repository.findBirthDateByLowestWherePhoneNoIsNotNull(birth_date);
        return user;
    }
}

