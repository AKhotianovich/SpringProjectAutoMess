package by.hotianovich.automess.services;


import by.hotianovich.automess.models.Make;
import by.hotianovich.automess.repositories.MakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MakeService {

    private final MakeRepository makeRepository;

    @ModelAttribute("Make")
    public List<Make> findAll(){
        return makeRepository.findAll();
    }
}
