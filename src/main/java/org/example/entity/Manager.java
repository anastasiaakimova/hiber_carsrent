package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "first_name", nullable = true, length = 120)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 120)
    private String lastName;

    @Basic
    @Column(name = "phone_number", nullable = true, length = 120)
    private String phoneNumber;

    @OneToMany(mappedBy = "manager", cascade = {CascadeType.ALL})
    private Collection<Contract> contracts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Collection<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (id != null ? !id.equals(manager.id) : manager.id != null) return false;
        if (firstName != null ? !firstName.equals(manager.firstName) : manager.firstName != null) return false;
        if (lastName != null ? !lastName.equals(manager.lastName) : manager.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(manager.phoneNumber) : manager.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
