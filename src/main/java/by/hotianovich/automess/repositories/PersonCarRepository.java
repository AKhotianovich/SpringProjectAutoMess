package by.hotianovich.automess.repositories;


import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.models.PersonCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCarRepository extends JpaRepository<PersonCar, Integer> {

    List<PersonCar> findByCarModel(Person reader);
}
