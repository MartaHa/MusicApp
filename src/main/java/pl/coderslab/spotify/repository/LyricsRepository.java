package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spotify.entity.Lyrics;

public interface LyricsRepository  extends JpaRepository<Lyrics, Long> {
}
