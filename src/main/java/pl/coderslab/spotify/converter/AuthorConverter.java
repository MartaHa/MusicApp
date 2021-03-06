package pl.coderslab.spotify.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spotify.entity.Author;
import pl.coderslab.spotify.repository.AuthorRepository;
import pl.coderslab.spotify.repository.CategoryRepository;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author convert(String s) {
        return authorRepository.getOne(Long.parseLong(s));
    }
}

