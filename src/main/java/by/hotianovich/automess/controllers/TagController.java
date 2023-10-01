package by.hotianovich.automess.controllers;



import by.hotianovich.automess.entity.UserCar;
import by.hotianovich.automess.services.UserCarService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            model.addAttribute("username", username);
        }
        List<UserCar> userCars = userCarService.findTagMakeCar(tag);
        model.addAttribute("personCars", userCars);
        return "index";
    }
}
