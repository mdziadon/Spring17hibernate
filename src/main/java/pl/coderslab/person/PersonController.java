package pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addPerson(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "Osoba dodana id = " + person.getId();
    }
}
