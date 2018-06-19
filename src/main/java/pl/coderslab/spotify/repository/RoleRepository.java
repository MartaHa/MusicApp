package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spotify.entity.Role;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByName(String name);
}
