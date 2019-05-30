package pl.coderslab.author;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author findAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteAuthorRalation(id);
        authorRepository.deleteById(id);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
