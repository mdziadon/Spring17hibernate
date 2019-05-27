package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    private PublisherService publisherService;

    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");

        Publisher publisher = new Publisher();
        publisher.setName("Wydawca testowy");
        publisherService.savePublisher(publisher);

        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        authorService.saveAuthor(author);
        List<Author> authors = new ArrayList<>();
        authors.add(author);

        book.setAuthors(authors);
        book.setPublisher(publisher);
        bookService.saveBook(book);
        return "Dodano ksiazke o id = " + book.getId();
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        book.setTitle("Thinking in Javaaa");
        bookService.updateBook(book);
        return "Zaktualizowano ksiazke o id = " + book.getId();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Usunieto ksiazke o id = " + id;
    }

    @GetMapping("/rating/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable int rating) {
        List<Book> books = bookService.findAllByRating(rating);
        return books.toString();
    }

}
