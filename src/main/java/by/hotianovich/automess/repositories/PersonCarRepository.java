package by.hotianovich.automess.repositories;

import by.hotianovich.automess.entity.Person;
import by.hotianovich.automess.entity.PersonCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonCarRepository extends JpaRepository<PersonCar, Integer> {

    List<PersonCar> findByPersonId(Person person);

    @Query("SELECT pc FROM PersonCar pc WHERE pc.licensePlate LIKE %:licensePlate%")
    List<PersonCar> findByLicensePlateContaining(String licensePlate);
}
