package by.hotianovich.automess.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Person")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    //@Size(min = 2, max = 100, message = "not valid")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    //@Size(min = 2, max = 100, message = "not valid")
    private String firstName;

    @Column(name = "last_name")
    //@Size(min = 2, max = 100, message = "not valid")
    private String lastName;

    @Column(name = "email")
    //@Size(min = 2, max = 100, message = "not valid")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;


    @OneToMany(mappedBy = "personId")
    private List<PersonCar> cars;

}
