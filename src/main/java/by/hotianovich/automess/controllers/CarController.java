package by.hotianovich.automess.controllers;

import by.hotianovich.automess.entity.CarBrands;
import by.hotianovich.automess.entity.User;
import by.hotianovich.automess.entity.UserCar;
import by.hotianovich.automess.repositories.UserRepository;
import by.hotianovich.automess.security.UserDetailsImpl;
import by.hotianovich.automess.security.UserDetailsServiceImpl;
import by.hotianovich.automess.services.CarBrandService;
import by.hotianovich.automess.services.UserCarService;
import by.hotianovich.automess.services.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@AllArgsConstructor
public class CarController {

    private final UserCarService userCarService;

    private final UserRepository userRepository;

    private final CarBrandService carBrandService;
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @ModelAttribute("tagDto")
    public List<CarBrands> tagAndCount() { return carBrandService.findAll(); }


    @GetMapping("/")
    public String showCars(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails);
        }
        logger.warn("Я работаю главная страница");
        model.addAttribute("userCar", userCarService.findAll());
        return "index";
    }

    @GetMapping("/profile")
    public String showPerson(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            String currentUsername = userDetails.getUsername();
            User currentUser = userRepository.findByEmail(currentUsername).orElseThrow(() -> new RuntimeException("User not found"));
            model.addAttribute("user", currentUser);
            logger.warn("Я не 2 работаю страница пользователя");
        }
        logger.warn("Я не работаю страница пользователя");
        return "car/showCar";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException() {
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchCars(@RequestParam("licensePlate") String licensePlate, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails);
        }
        List<UserCar> cars = userCarService.findByLicensePlateContaining(licensePlate);
        model.addAttribute("userCar", cars);
        return "index";
    }





}

