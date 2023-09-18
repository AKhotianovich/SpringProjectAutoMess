package by.hotianovich.automess.services;


import by.hotianovich.automess.entity.CarBrands;
import by.hotianovich.automess.repositories.CarBrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class CarBrandService {

    private final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    public List<CarBrands> findAll(){
        return carBrandRepository.findAll();
    }
}
