package by.hotianovich.automess.services;


import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }


    public Person findOneById(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }
}
