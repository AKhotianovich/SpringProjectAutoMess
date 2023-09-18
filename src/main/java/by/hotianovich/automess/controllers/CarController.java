package by.hotianovich.automess.controllers;

import by.hotianovich.automess.entity.CarBrands;
import by.hotianovich.automess.entity.UserCar;
import by.hotianovich.automess.services.CarBrandService;
import by.hotianovich.automess.services.UserCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@AllArgsConstructor
public class CarController {

    private final UserCarService userCarService;

    private final CarBrandService carBrandService;

    @ModelAttribute("tagDto")
    public List<CarBrands> tagAndCount() { return carBrandService.findAll(); }


    @GetMapping("/")
    public String showCars(Model model) {
        model.addAttribute("userCar", userCarService.findAll());
        return "index";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException() {
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchCars(@RequestParam("licensePlate") String licensePlate, Model model) {
        List<UserCar> cars = userCarService.findByLicensePlateContaining(licensePlate);
        model.addAttribute("personCars", cars);
        return "index";
    }


    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {
        UserCar userCar = userCarService.findOneById(id);
        model.addAttribute("personCars", userCar);
        return "car/showCar";
    }
}

