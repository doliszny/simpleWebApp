package pl.doliszny.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @CsvBindByName
    @Column(name = "first_name")
    @NotEmpty(message = "Podaj imie")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Błędne imie - nazwisko składa się z liter")
    private String first_name;

    @CsvBindByName
    @Column(name = "last_name")
    @NotEmpty(message = "Podaj imie")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Błędne nazwisko - nazwisko składa się z liter")
    private String last_name;

    @NotEmpty(message = "Podaj datę urodzenia")
    @CsvBindByName
    @Column(name = "birth_date")
    @Pattern(regexp = "((?:19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])", message = "format daty to xxxx.xx.xx")
    private String birth_date;

    @CsvBindByName
    @Column(name = "phone_no")
    @Pattern(regexp="(^$|[0-9]{9})", message = "zly format telefonu - telefon to 9 cyfr")
    private String phone_no;
}