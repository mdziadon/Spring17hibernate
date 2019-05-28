package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorService authorService;

    @Override
    public Author convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        return authorService.findAuthor(Long.valueOf(s));
    }

}
