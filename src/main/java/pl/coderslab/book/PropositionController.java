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
import pl.coderslab.validation.PropositionValidationGroup;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/propositions")
public class PropositionController {

    private BookService bookService;

    private PublisherService publisherService;

    private AuthorService authorService;

    @Autowired
    public PropositionController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
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
    public String addBook(@ModelAttribute @Validated(PropositionValidationGroup.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
        book.setProposition(true);
        bookService.saveBook(book);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String propositionList(Model model) {
        List<Book> propositions = bookService.findPropositions();
        model.addAttribute("propositions", propositions);
        return "propositionList";
    }

    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookWithAuthors(id);
        model.addAttribute("book", book);
        return "book";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@ModelAttribute @Validated(PropositionValidationGroup.class) Book book, BindingResult result) {
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

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

}
