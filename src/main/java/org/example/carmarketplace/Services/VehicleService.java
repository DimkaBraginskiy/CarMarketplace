package org.example.carmarketplace.Services;

import org.example.carmarketplace.Models.Vehicle;
import org.example.carmarketplace.Repositories.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepo;

    public VehicleService(VehicleRepository vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public byte[] getVehicleImageById(Long id) {
        Vehicle vehicle = vehicleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return vehicle.getImage();
    }
}
