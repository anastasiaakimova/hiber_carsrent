package org.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "date", nullable = true)
    private Date date;
    @Basic
    @Column(name = "amount_of_days", nullable = true)
    private Integer amountOfDays;

    @Basic
    @Column(name = "cost", nullable = true, precision = 3)
    private BigDecimal cost;

    @Access(AccessType.PROPERTY)
    @ManyToOne(targetEntity = Car.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "car", referencedColumnName = "id")
    private Car car;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "manager", referencedColumnName = "id")
    private Manager manager;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmountOfDays() {
        return amountOfDays;
    }

    public void setAmountOfDays(Integer amountOfDays) {
        this.amountOfDays = amountOfDays;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car carByCar) {
        this.car = carByCar;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client clientByClient) {
        this.client = clientByClient;
    }


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager managerByManager) {
        this.manager = managerByManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (id != null ? !id.equals(contract.id) : contract.id != null) return false;
        if (date != null ? !date.equals(contract.date) : contract.date != null) return false;
        if (amountOfDays != null ? !amountOfDays.equals(contract.amountOfDays) : contract.amountOfDays != null)
            return false;
        if (cost != null ? !cost.equals(contract.cost) : contract.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (amountOfDays != null ? amountOfDays.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
