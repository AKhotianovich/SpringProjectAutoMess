package by.hotianovich.automess.services;


import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;


    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }


    public Person findOneById(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }
}
