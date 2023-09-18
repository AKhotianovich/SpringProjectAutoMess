package by.hotianovich.automess.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "carbrands")
@Getter
@Setter
@NoArgsConstructor
public class CarBrands {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name")
    private String brand_name;


    @Column(name = "country_of_origin")
    private String country_of_origin;

//    @Column(name = "logo_image")
//    private Byte[] logo_image;

    @OneToMany(mappedBy = "brandId")
    private List<UserCar> make;


}
