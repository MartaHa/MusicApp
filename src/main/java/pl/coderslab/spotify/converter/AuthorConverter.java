package pl.coderslab.spotify.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spotify.entity.Author;
import pl.coderslab.spotify.repository.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {


    @Autowired
    private AuthorRepository authors;


    @Override
    public Author convert(String source) {
        Author author = authors.getOne(Long.parseLong(source));
        return  author;
    }
}

