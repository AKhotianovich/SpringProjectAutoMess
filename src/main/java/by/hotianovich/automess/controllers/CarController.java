package by.hotianovich.automess.controllers;

import by.hotianovich.automess.dto.TagDto;
import by.hotianovich.automess.entity.Make;
import by.hotianovich.automess.entity.PersonCar;
import by.hotianovich.automess.services.MakeService;
import by.hotianovich.automess.services.PersonCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@AllArgsConstructor
public class CarController {

    private final PersonCarService personCarService;

    private final MakeService makeService;

    @ModelAttribute("tagDto")
    public List<Make> tagAndCount() { return makeService.findAll(); }


    @GetMapping("/")
    public String showCars(Model model) {
        model.addAttribute("personCars", personCarService.findAll());
        return "index";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException() {
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchCars(@RequestParam("licensePlate") String licensePlate, Model model) {
        List<PersonCar> cars = personCarService.findByLicensePlateContaining(licensePlate);
        model.addAttribute("personCars", cars);
        return "index";
    }


    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {
        PersonCar personCar = personCarService.findOneById(id);
        model.addAttribute("personCars", personCar);
        return "car/showCar";
    }
}

