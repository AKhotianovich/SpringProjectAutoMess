package by.hotianovich.automess.controllers;



import by.hotianovich.automess.entity.UserCar;
import by.hotianovich.automess.services.UserCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class TagController {

    private final UserCarService userCarService;

    @GetMapping("/tag/{tagMake}")
    public String showPerson(@PathVariable("tagMake") String tag, Model model) {
        List<UserCar> userCars = userCarService.findTagMakeCar(tag);
        model.addAttribute("personCars", userCars);
        return "index";
    }
}
