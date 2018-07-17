package pl.coderslab.spotify.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spotify.entity.Album;
import pl.coderslab.spotify.entity.Author;
import pl.coderslab.spotify.repository.AlbumRepository;
import pl.coderslab.spotify.repository.AuthorRepository;

public class AlbumConverter implements Converter<String, Album> {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Album convert(String s) {
        return albumRepository.getOne(Long.parseLong(s));
    }
}

