package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorRepository;

import java.util.List;

@Controller
public class TestRepositoryController {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    public TestRepositoryController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Autowired


    @GetMapping("/findAll")
    @ResponseBody
    public String getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.toString();
    }

    @GetMapping("/findByTitle/{title}")
    @ResponseBody
    public String findByTitle(@PathVariable String title) {
        List<Book> books = bookRepository.findByTitle(title);
        return books.toString();
    }

    @GetMapping("/findByCategoryId/{id}")
    @ResponseBody
    public String findByCategoryId(@PathVariable Long id) {
        List<Book> books = bookRepository.findByCategoryId(id);
        return books.toString();
    }

    @GetMapping("/findByAuthorsId/{id}")
    @ResponseBody
    public String findByAuthorsId(@PathVariable Long id) {
        List<Book> books = bookRepository.findByAuthorsId(id);
        return books.toString();
    }

    @GetMapping("/findByPublisherId/{id}")
    @ResponseBody
    public String findByPublisherId(@PathVariable Long id) {
        List<Book> books = bookRepository.findByPublisherId(id);
        return books.toString();
    }

    @GetMapping("/findByRatingGreaterThanEqual/{rating}")
    @ResponseBody
    public String findByRatingGreaterThanEqual(@PathVariable int rating) {
        List<Book> books = bookRepository.findByRatingGreaterThanEqual(rating);
        return books.toString();
    }

    @GetMapping("/findFirstByCategoryIdOrderByTitle/{id}")
    @ResponseBody
    public String findFirstByCategoryIdOrderByTitle(@PathVariable Long id) {
        Book book = bookRepository.findFirstByCategoryIdOrderByTitleQuery(id);
        return book.toString();
    }

    @GetMapping("/findByEmailQuery/{emailPrefix}")
    @ResponseBody
    public String findByEmailQuery(@PathVariable String emailPrefix) {
        List<Author> authors = authorRepository.findByEmailQuery(emailPrefix);
        return authors.toString();
    }
}
