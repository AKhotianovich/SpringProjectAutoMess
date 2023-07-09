package by.hotianovich.automess.controllers;



import by.hotianovich.automess.entity.PersonCar;
import by.hotianovich.automess.services.MakeService;
import by.hotianovich.automess.services.PersonCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class TagController {

    private final PersonCarService personCarService;

    @GetMapping("/tag/{tagMake}")
    public String showPerson(@PathVariable("tagMake") String tag, Model model) {
        List<PersonCar> personCars = personCarService.findTagMakeCar(tag);
        model.addAttribute("personCars", personCars);
        return "index";
    }
}
