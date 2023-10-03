package by.hotianovich.automess.services;


import by.hotianovich.automess.entity.User;
import by.hotianovich.automess.entity.UserCar;
import by.hotianovich.automess.repositories.UserCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserCarService {

    private final UserCarRepository userCarRepository;


    public List<UserCar> findAll() {
        return userCarRepository.findAll();
    }


    public UserCar findOneById(int id) {
        Optional<UserCar> personCar = userCarRepository.findById(id);
        return personCar.orElse(null);
    }

    public void saveUserCar(UserCar userCar){
        userCarRepository.save(userCar);
    }


    public List<UserCar> findByLicensePlateContaining(String licensePlate) {
        return userCarRepository.findByLicensePlateContaining(licensePlate);
    }

//    public List<UserCar> findByUserId(int UserId) {
//        return userCarRepository.findByUserId(UserId);
//    }

    public List<UserCar> findTagMakeCar(String tag) {
        return userCarRepository.findTagMakeCar(tag);
    }
}
