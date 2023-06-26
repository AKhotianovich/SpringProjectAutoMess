package by.hotianovich.automess.repositories;

import by.hotianovich.automess.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
