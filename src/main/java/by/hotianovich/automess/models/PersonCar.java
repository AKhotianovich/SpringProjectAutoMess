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

    @ManyToOne
    @JoinColumn(name = "makeId", referencedColumnName = "id")
    private Make makeId;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "car_vin")
    private String carVin;
}
