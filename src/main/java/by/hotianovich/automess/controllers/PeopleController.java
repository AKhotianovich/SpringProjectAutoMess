package by.hotianovich.automess.controllers;

import by.hotianovich.automess.services.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PeopleController {

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public String showPeople(Model model){
        return
    }
}
