package by.hotianovich.automess.services;


import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.models.PersonCar;
import by.hotianovich.automess.repositories.PersonCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonCarService {

    private final PersonCarRepository personCarRepository;

    public List<PersonCar> findAll(){
        return personCarRepository.findAll();
    }

    public List<PersonCar> findByCarModel(Person person) {
        return personCarRepository.findByCarModel(person);
    }

    public List<PersonCar> findByLicensePlateContaining(String licensePlate) {
        return personCarRepository.findByLicensePlateContaining(licensePlate);
    }
}
