package by.hotianovich.automess.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    //@Size(min = 2, max = 100, message = "not valid")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    //@Size(min = 2, max = 100, message = "not valid")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "first_name")
    //@Size(min = 2, max = 100, message = "not valid")
    private String firstName;

    @Column(name = "last_name")
    //@Size(min = 2, max = 100, message = "not valid")
    private String lastName;

    @Column(name = "role")
    //@Size(min = 2, max = 100, message = "not valid")
    private ERole role = ERole.USER_ROLE;

    @OneToMany(mappedBy = "userId")
    private List<UserCar> cars;

    public List<UserCar> getCars() {
        return cars;
    }

}
