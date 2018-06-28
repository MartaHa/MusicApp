package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spotify.entity.Author;

public interface AuthorRepository extends JpaRepository <Author, Long> {
}
