package by.hotianovich.automess.repositories;

import by.hotianovich.automess.entity.Person;
import by.hotianovich.automess.entity.PersonCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCarRepository extends JpaRepository<PersonCar, Integer> {

    List<PersonCar> findByPersonId(Person person);

    @Query("SELECT pc FROM PersonCar pc WHERE pc.licensePlate LIKE %:licensePlate%")
    List<PersonCar> findByLicensePlateContaining(String licensePlate);

    @Query("SELECT pc FROM PersonCar pc JOIN pc.makeId mk WHERE mk.mark LIKE %:tag%")
    List<PersonCar> findTagMakeCar(@Param("tag") String tag);
}
