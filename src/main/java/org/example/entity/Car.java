package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "model", nullable = true, length = 120)
    private String model;
    @Basic
    @Column(name = "color", nullable = true, length = 120)
    private String color;
    @Basic
    @Column(name = "price", nullable = true, precision = 3)
    private Integer price;

    @Basic
    @Column(name = "availability", nullable = true)
    private Integer availability;

    @OneToMany(targetEntity=Contract.class, mappedBy = "car", cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    private Collection<Contract> contracts;

   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

   public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        if (price != null ? !price.equals(car.price) : car.price != null) return false;
        if (availability != null ? !availability.equals(car.availability) : car.availability != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id " + id +
                ", model " + model +
                ", color " + color  +
                ", price " + price +
                ", availability " + availability;
    }

    public Collection<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Collection<Contract> contractsById) {
        this.contracts = contractsById;
    }
}
