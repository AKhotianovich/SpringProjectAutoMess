package by.hotianovich.automess.security;

import by.hotianovich.automess.entity.User;
import by.hotianovich.automess.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Override
    @Transactional
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.warn("User: {}", username);
        User user = userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException(
                        "User with email" + username + "not found"
                ));
        logger.warn(user.toString());
        return UserDetailsImpl.build(user);
    }
}
