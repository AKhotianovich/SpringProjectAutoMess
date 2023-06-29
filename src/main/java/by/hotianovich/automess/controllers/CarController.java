package by.hotianovich.automess.controllers;

import by.hotianovich.automess.entity.Make;
import by.hotianovich.automess.entity.Person;
import by.hotianovich.automess.entity.PersonCar;
import by.hotianovich.automess.services.MakeService;
import by.hotianovich.automess.services.PeopleService;
import by.hotianovich.automess.services.PersonCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {

    private final PersonCarService personCarService;
    private final PeopleService peopleService;
    private final MakeService makeService;

    @Autowired
    public CarController(PersonCarService personCarService, PeopleService peopleService, MakeService makeService) {
        this.personCarService = personCarService;
        this.peopleService = peopleService;
        this.makeService = makeService;
    }

    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           Model model) {
        Page<PersonCar> carPage = personCarService.findAll(page, pageSize);
        model.addAttribute("personCars", carPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", carPage.getTotalPages());
        return "index";
    }



    @GetMapping("/cars/search")
    public String searchCars(@RequestParam("licensePlate") String licensePlate, Model model) {
        List<PersonCar> cars = personCarService.findByLicensePlateContaining(licensePlate);
        model.addAttribute("personCars", cars);
        return "index";
    }


    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {
        Person person = peopleService.findOneById(id);
        List<PersonCar> PersonCar = personCarService.findByPersonId(person);
        model.addAttribute("person", person);
        if (!PersonCar.isEmpty()) {
            model.addAttribute("PersonCar", PersonCar);
        }
        return "people/profile";
    }
}

