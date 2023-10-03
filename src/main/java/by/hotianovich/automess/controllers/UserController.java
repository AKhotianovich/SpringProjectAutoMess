package by.hotianovich.automess.controllers;

import by.hotianovich.automess.entity.CarBrands;
import by.hotianovich.automess.entity.User;
import by.hotianovich.automess.entity.UserCar;
import by.hotianovich.automess.repositories.CarBrandRepository;
import by.hotianovich.automess.repositories.UserRepository;
import by.hotianovich.automess.security.UserDetailsImpl;
import by.hotianovich.automess.services.UserCarService;
import by.hotianovich.automess.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    UserService userService;
    UserCarService userCarService;
    private final CarBrandRepository carBrandRepository;
    private final UserRepository userRepository;
    @GetMapping("/login")
    public String loginPage(){
        return "forms/login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("User", new User());
        return "forms/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user, Model model){
        userService.saveUser(user);
        return "redirect:forms/login";
    }

    @GetMapping("/addCar")
    public String addCar(Model model){
        List<CarBrands> carBrands = carBrandRepository.findAll();
        model.addAttribute("car", new UserCar());
        model.addAttribute("carBrands", carBrands);
        return "car/addCar";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute("car") UserCar userCar, @RequestParam("carBrand") int carBrandId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            CarBrands carBrand = carBrandRepository.findById(carBrandId).orElseThrow(() -> new RuntimeException("Car brand not found"));
            String currentUsername = userDetails.getUsername();
            // Далее используйте текущее имя пользователя для получения объекта User из базы данных
            User currentUser = userRepository.findByEmail(currentUsername).orElseThrow(() -> new RuntimeException("User not found"));
            userCar.setUserId(currentUser);
            userCar.setBrandId(carBrand);
            userCarService.saveUserCar(userCar);
            return "redirect:/addCar";
        }

        return "redirect:/error-page";
    }
}
