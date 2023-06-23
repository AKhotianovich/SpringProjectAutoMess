package by.hotianovich.automess.controllers;

import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.models.PersonCar;
import by.hotianovich.automess.repositories.PersonCarRepository;
import by.hotianovich.automess.services.PeopleService;
import by.hotianovich.automess.services.PersonCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PeopleService peopleService;

    private PersonCarService personCarService;


    @Autowired
    public PeopleController(PeopleService peopleService, PersonCarService personCarService) {
        this.peopleService = peopleService;
        this.personCarService = personCarService;
    }

    @GetMapping()
    public String showPeople(Model model){
        model.addAttribute("people", peopleService.findAll());
        return "people/new";
    }


    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {
        Person person = peopleService.findOneById(id);
        List<PersonCar> personCars = personCarService.findByCarModel(person);
        model.addAttribute("person", person);
        if (!personCars.isEmpty()) {
            model.addAttribute("personCars", personCars);
        }
        return "people/profile";
    }
}
