package org.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Contract {
    private Long id;
    private Date date;
    private Integer amountOfDays;
    private BigDecimal cost;
    private Car carByCar;
    private Client clientByClient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "amount_of_days", nullable = true)
    public Integer getAmountOfDays() {
        return amountOfDays;
    }

    public void setAmountOfDays(Integer amountOfDays) {
        this.amountOfDays = amountOfDays;
    }

    @Basic
    @Column(name = "cost", nullable = true, precision = 3)
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

    @ManyToOne
    @JoinColumn(name = "car", referencedColumnName = "id")
    public Car getCarByCar() {
        return carByCar;
    }

    public void setCarByCar(Car carByCar) {
        this.carByCar = carByCar;
    }

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id")
    public Client getClientByClient() {
        return clientByClient;
    }

    public void setClientByClient(Client clientByClient) {
        this.clientByClient = clientByClient;
    }
}
