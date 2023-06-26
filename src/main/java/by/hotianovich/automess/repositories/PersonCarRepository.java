package by.hotianovich.automess.repositories;


import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.models.PersonCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonCarRepository extends JpaRepository<PersonCar, Integer> {

    List<PersonCar> findByCarModel(Person reader);
}
