package by.hotianovich.automess.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "person_car")
@Getter
@Setter
@NoArgsConstructor
public class PersonCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "make_id", referencedColumnName = "id")
    private Make makeId;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personId;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "car_vin")
    private String carVin;


}
