package by.hotianovich.automess.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "usercars")
@Getter
@Setter
@NoArgsConstructor
public class UserCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private CarBrands brandId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @Column(name = "model")
    private String carModel;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "vin_code")
    private String carVin;

//    @Column(name = "car_photo")
//    private Byte[] car_photo;


}
