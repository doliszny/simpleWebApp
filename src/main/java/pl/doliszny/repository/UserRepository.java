package pl.doliszny.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.doliszny.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findOldestUser(String birth_date);

}
