package by.hotianovich.automess.models;

//import javax.persistence.*;
import java.lang.*;
import jakarta.persistence.*;

@Entity
@Table(name="Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    private String phone_number;


    public Person() {
    }

    public Person(String login, String password, String firstName, String lastName, String email, String phone_number) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
