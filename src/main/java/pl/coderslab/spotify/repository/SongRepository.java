package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spotify.entity.Song;

public interface SongRepository extends JpaRepository <Song, Long> {
}
