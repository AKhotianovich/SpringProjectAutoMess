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




//    public PersonCar(String carModel, String licensePlate, String carVin) {
//        this.carModel = carModel;
//        this.licensePlate = licensePlate;
//        this.carVin = carVin;
//    }

    public PersonCar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Make getMakeId() {
        return makeId;
    }

    public void setMakeId(Make makeId) {
        this.makeId = makeId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

}
