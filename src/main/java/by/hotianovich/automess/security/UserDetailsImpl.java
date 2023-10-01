package by.hotianovich.automess.security;

import by.hotianovich.automess.entity.User;
import by.hotianovich.automess.entity.UserCar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private Integer id;
    private String login;
    private String password;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private List<UserCar> carBrands;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Integer id, String login, String password, String email, String phoneNumber, String firstName, String lastName, List<UserCar> carBrands, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.carBrands = carBrands;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority(user.getRole().name()));
        return new UserDetailsImpl(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getFirstName(),
                user.getLastName(),
                user.getCars(),
                authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
