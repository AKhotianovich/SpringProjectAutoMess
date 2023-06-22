package by.hotianovich.automess.models;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person_car")
public class PersonCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Make makeId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person personId;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "car_vin")
    private String carVin;
}
