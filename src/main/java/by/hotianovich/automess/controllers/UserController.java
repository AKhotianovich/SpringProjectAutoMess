package by.hotianovich.automess.controllers;

import by.hotianovich.automess.entity.User;
import by.hotianovich.automess.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

    UserService userService;
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
}
