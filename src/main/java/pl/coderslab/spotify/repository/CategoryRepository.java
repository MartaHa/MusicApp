package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.spotify.entity.Category;
import pl.coderslab.spotify.entity.Song;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category, Long> {

    @Query(value = "SELECT category_id FROM category WHERE category_name= ?1", nativeQuery = true)
    long findSongsbyCategory(String category);
}
