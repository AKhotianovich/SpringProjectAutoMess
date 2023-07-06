package by.hotianovich.automess.services;


import by.hotianovich.automess.entity.Person;
import by.hotianovich.automess.entity.PersonCar;
import by.hotianovich.automess.repositories.PersonCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonCarService {

    private final PersonCarRepository personCarRepository;


    public PersonCarService(PersonCarRepository personCarRepository) {
        this.personCarRepository = personCarRepository;
    }

    public List<PersonCar> findAll() {
        return personCarRepository.findAll();
    }

    public Page<PersonCar> getPageOfPersonCars(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return personCarRepository.findAll(nextPage);
    }

    public PersonCar findOneById(int id) {
        Optional<PersonCar> personCar = personCarRepository.findById(id);
        return personCar.orElse(null);
    }

    public List<PersonCar> findByPersonId(Person person) {
        return personCarRepository.findByPersonId(person);
    }

    public List<PersonCar> findByLicensePlateContaining(String licensePlate) {
        return personCarRepository.findByLicensePlateContaining(licensePlate);
    }
}
