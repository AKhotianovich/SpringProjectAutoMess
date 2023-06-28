package by.hotianovich.automess.repositories;


import by.hotianovich.automess.models.Person;
import by.hotianovich.automess.models.PersonCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonCarRepository extends JpaRepository<PersonCar, Integer> {

    List<PersonCar> findByCarModel(Person reader);

    @Query("SELECT pc FROM PersonCar pc WHERE pc.licensePlate LIKE %:licensePlate%")
    List<PersonCar> findByLicensePlateContaining(String licensePlate);
}
