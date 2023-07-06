package by.hotianovich.automess.services;


import by.hotianovich.automess.entity.Person;
import by.hotianovich.automess.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

}
