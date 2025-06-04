package org.example.carmarketplace.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fuel_type")
public class FuelType {
    @Id
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "fuelTypes")
    private List<Vehicle> vehicles;

    public FuelType(Long id, String name, List<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.vehicles = vehicles;
    }

    public FuelType() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
