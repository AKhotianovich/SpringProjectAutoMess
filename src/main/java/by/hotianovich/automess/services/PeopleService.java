package by.hotianovich.automess.services;



import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;


    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @ModelAttribute("Person")
    public List<Person> findAll(){
        return peopleRepository.findAll();
    }
}
