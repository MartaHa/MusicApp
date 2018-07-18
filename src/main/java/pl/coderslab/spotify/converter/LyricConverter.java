package pl.coderslab.spotify.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spotify.entity.Lyrics;
import pl.coderslab.spotify.repository.LyricsRepository;

public class LyricConverter implements Converter< String, Lyrics> {

    @Autowired
    LyricsRepository lyricsRepository;

    @Override
    public Lyrics convert(String s) {
        return lyricsRepository.getOne(Long.parseLong(s));
    }

}
