package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    private PublisherService publisherService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");

        Publisher publisher = new Publisher();
        publisher.setName("Wydawca testowy");
        publisherService.savePublisher(publisher);

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

}
