package by.hotianovich.automess.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Make")
@Getter
@Setter
@NoArgsConstructor
public class Make {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mark")
    private String mark;


    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "makeId")
    private List<PersonCar> cars;

}
