package pl.coderslab.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public Book findBook(Long id) {
        return bookDao.findBook(id);
    }

    public void deleteBook(Long id) {
        bookDao.deleteBook(id);
    }
}
