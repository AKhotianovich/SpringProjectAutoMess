package by.hotianovich.automess.repositories;

import by.hotianovich.automess.entity.User;
import by.hotianovich.automess.entity.UserCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCarRepository extends JpaRepository<UserCar, Integer> {

    List<UserCar> findByUserId(User user);

    @Query("SELECT uc FROM UserCar uc WHERE uc.licensePlate LIKE %:licensePlate%")
    List<UserCar> findByLicensePlateContaining(String licensePlate);

    @Query("SELECT uc FROM UserCar uc JOIN uc.brandId mk WHERE mk.brand_name LIKE %:tag%")
    List<UserCar> findTagMakeCar(@Param("tag") String tag);

    Optional<UserCar> deleteUserCarById(Integer id);
}
