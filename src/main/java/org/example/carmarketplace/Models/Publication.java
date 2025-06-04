package org.example.carmarketplace.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(length = 500, nullable = true)
    private String description;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public Publication(Long id, Boolean isActive, String description, Double price, Vehicle vehicle) {
        this.id = id;
        this.isActive = isActive;
        this.description = description;
        this.price = price;
        this.vehicle = vehicle;
    }

    public Publication() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
