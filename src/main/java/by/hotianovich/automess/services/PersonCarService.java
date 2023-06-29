package by.hotianovich.automess.services;


import by.hotianovich.automess.entity.Person;
import by.hotianovich.automess.entity.PersonCar;
import by.hotianovich.automess.repositories.PersonCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class PersonCarService {

    private final PersonCarRepository personCarRepository;

    @Autowired
    public PersonCarService(PersonCarRepository personCarRepository) {
        this.personCarRepository = personCarRepository;
    }

    public Page<PersonCar> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return personCarRepository.findAll(pageable);
    }

    public List<PersonCar> findByPersonId(Person person) {
        return personCarRepository.findByPersonId(person);
    }

    public List<PersonCar> findByLicensePlateContaining(String licensePlate) {
        return personCarRepository.findByLicensePlateContaining(licensePlate);
    }
}
