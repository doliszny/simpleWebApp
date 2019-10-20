package pl.doliszny.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.doliszny.model.User;

import java.awt.print.Pageable;
import java.util.List;

public interface UserListRepository extends PagingAndSortingRepository<User, Long> {

    //lista użytkowników posortowana po wieku (dane do wypisania: imię, nazwisko, wiek, nr. tel), mile widziana paginacja wyników (domyślnie: 5 per strona)
    Page<User> findAllOrderByBirthDate(String birth_date, Pageable pageable);
}
