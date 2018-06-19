package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spotify.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
