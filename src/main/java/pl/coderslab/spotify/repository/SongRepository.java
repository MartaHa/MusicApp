package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.spotify.entity.Song;

import java.util.List;

public interface SongRepository extends JpaRepository <Song, Long> {

    @Query(value = "SELECT * FROM song WHERE category= ?1", nativeQuery = true)
    List<Song> findSongsbyCategory(String category);

    @Query(value = "SELECT * FROM ride WHERE rating = ?1", nativeQuery = true)
    List <Song> findSongByRating(String rating);
}
