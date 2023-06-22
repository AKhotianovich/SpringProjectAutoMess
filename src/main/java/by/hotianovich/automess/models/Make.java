package by.hotianovich.automess.models;


import javax.persistence.*;



@Entity
@Table(name = "Make")
public class Make {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    private int id;

    @Column(name = "mark")
    private String mark;


    @Column(name = "country")
    private String country;

    public Make() {
    }

    public Make(String mark, String country) {
        this.mark = mark;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
