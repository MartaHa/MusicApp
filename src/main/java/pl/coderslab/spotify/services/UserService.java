package pl.coderslab.spotify.services;

import pl.coderslab.spotify.entity.User;

public interface UserService {

    User findByUsername(String username);

    void saveUser(User user, String role);
}


