package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spotify.entity.Category;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
