package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestRepositoryController {

    private BookRepository bookRepository;

    @Autowired
    public TestRepositoryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
}
