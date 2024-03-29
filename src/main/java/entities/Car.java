package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Car.deleteAllRows", query = "DELETE from Car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private String make;
    private String model;
    private int price;

    public Car(int year, String make, String model, int price) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
    }
    
    public Car() {
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
