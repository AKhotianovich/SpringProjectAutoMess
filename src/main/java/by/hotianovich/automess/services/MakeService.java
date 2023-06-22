package by.hotianovich.automess.services;


import by.hotianovich.automess.models.Make;
import by.hotianovich.automess.repositories.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class MakeService {

    private MakeRepository makeRepository;

    @Autowired
    public MakeService(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    @ModelAttribute("Make")
    public List<Make> findAll(){
        return makeRepository.findAll();
    }
}
