package by.hotianovich.automess.dto;

import by.hotianovich.automess.entity.PersonCar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PersonCarDTO {

    private Integer count;
    private List<PersonCar> PersonCars;



}
