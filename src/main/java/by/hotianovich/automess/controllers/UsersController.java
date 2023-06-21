package by.hotianovich.automess.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findUsers")
public class UsersController {


    @GetMapping()
    public String getAllUsers(){
        return "Hello";
    }


}
