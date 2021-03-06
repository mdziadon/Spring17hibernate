package pl.coderslab.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.author.Author;
import pl.coderslab.book.Book;
import pl.coderslab.publisher.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    private Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/book/validate")
    public String validateBook(Model model) {
        Book book = new Book();
        book.setTitle("asdasdasd");

        List<ErrorInfo> list = new ArrayList<>();
        Set<ConstraintViolation<Book>> errors = validator.validate(book);
        if (!errors.isEmpty()) {
            for (ConstraintViolation<Book> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                list.add(new ErrorInfo(path, message));
            }
        }
        model.addAttribute("errors", list);
        return "errors";
    }

    @GetMapping("/author/validate")
    public String validateAuthor(Model model) {
        Author author = new Author();
        author.setPesel("123");
        author.setEmail("asd@test.pl");
        author.setYearOfBirth(2000);

        List<ErrorInfo> list = new ArrayList<>();
        Set<ConstraintViolation<Author>> errors = validator.validate(author);
        if (!errors.isEmpty()) {
            for (ConstraintViolation<Author> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                list.add(new ErrorInfo(path, message));
            }
        }
        model.addAttribute("errors", list);
        return "errors";
    }

    @GetMapping("/publisher/validate")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        publisher.setNip("3922204273");
        publisher.setRegon("938359290");

        List<ErrorInfo> list = new ArrayList<>();
        Set<ConstraintViolation<Publisher>> errors = validator.validate(publisher);
        if (!errors.isEmpty()) {
            for (ConstraintViolation<Publisher> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                list.add(new ErrorInfo(path, message));
            }
        }
        model.addAttribute("errors", list);
        return "errors";
    }
}
