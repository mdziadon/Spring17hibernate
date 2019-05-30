package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public Book findBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book findBookWithAuthors(Long id) {
        Book book = findBook(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findBooks() {
        return bookRepository.findAllByProposition(false);
    }

    public List<Book> findPropositions() {
        return bookRepository.findAllByProposition(true);
    }

    public List<Book> findBooksByRating(int rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }
}
