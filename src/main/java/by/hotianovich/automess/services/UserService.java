package by.hotianovich.automess.services;


import by.hotianovich.automess.entity.User;
import by.hotianovich.automess.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        user.setPassword(encoder().encode(user.getPassword()));
        userRepository.save(user);
    }

}
