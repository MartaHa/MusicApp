package pl.coderslab.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spotify.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
