package pl.coderslab.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.Book;

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

    @GetMapping("/validate")
    public String validate(Model model) {
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
}
