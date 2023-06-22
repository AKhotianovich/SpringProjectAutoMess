package by.hotianovich.automess.repositories;


import by.hotianovich.automess.models.PersonCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCarRepository extends JpaRepository<PersonCar, Integer> {
}
