package pl.coderslab.spotify.services;

import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spotify.entity.User;

public interface UserService {

    User findByUsername(String username);
    @Transactional
    void saveUser(User user, String role);



}


