package by.hotianovich.automess.services;


import by.hotianovich.automess.models.PersonCar;
import by.hotianovich.automess.repositories.PersonCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonCarService {

    private PersonCarRepository personCarRepository;

    public PersonCarService(PersonCarRepository personCarRepository) {
        this.personCarRepository = personCarRepository;
    }

    public List<PersonCar> findAll(){
        return personCarRepository.findAll();
    }
}
