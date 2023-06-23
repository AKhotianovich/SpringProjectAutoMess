package by.hotianovich.automess.services;


import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.models.PersonCar;
import by.hotianovich.automess.repositories.PersonCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class PersonCarService {

    private PersonCarRepository personCarRepository;

    @Autowired
    public PersonCarService(PersonCarRepository personCarRepository) {
        this.personCarRepository = personCarRepository;
    }

    public List<PersonCar> findAll(){
        return personCarRepository.findAll();
    }

    public List<PersonCar> findByCarModel(Person person) {
        return personCarRepository.findByCarModel(person);
    }
}
