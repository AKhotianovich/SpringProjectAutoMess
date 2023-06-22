package by.hotianovich.automess.controllers;


import by.hotianovich.automess.repositories.MakeRepository;
import by.hotianovich.automess.services.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/make")
public class MakeController {

    private MakeService makeService;

    @Autowired
    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    @GetMapping()
    public String showMake(Model model){
        model.addAttribute("make", makeService.findAll());
        return "make/makeShow";
    }

}
