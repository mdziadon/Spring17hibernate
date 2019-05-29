package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;
import pl.coderslab.validation.BookValidationGroup;

import javax.validation.Valid;
import javax.validation.groups.Default;
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
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute @Validated(BookValidationGroup.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
        bookService.saveBook(book);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String bookList(Model model) {
        List<Book> books = bookService.findBooks();
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookWithAuthors(id);
        model.addAttribute("book", book);
        return "book";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@ModelAttribute @Validated(BookValidationGroup.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
        bookService.updateBook(book);
        return "redirect:../list";
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:../list";
    }

    @GetMapping("/rating/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable int rating) {
        List<Book> books = bookService.findBooksByRating(rating);
        return books.toString();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String findById(@PathVariable Long id) {
        Book book = bookService.findBookWithAuthors(id);
        return book.toString();
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }
}
