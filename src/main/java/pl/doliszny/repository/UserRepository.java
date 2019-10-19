package pl.doliszny.repository;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.doliszny.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //ile jest użytkowników
    Long countById(Long Id);

    //lista użytkowników posortowana po wieku (dane do wypisania: imię, nazwisko, wiek, nr. tel), mile widziana paginacja wyników (domyślnie: 5 per strona)
    List<User> findAllOrderByBirthDate(String birth_date);

    //najstarszy użytkownik z numerem telefonu

    User findBirthDateByLowestWherePhoneNoIsNotNull(String birth_date);



}
