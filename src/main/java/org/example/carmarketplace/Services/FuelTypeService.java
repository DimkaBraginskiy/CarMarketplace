package org.example.carmarketplace.Services;

import org.example.carmarketplace.Models.FuelType;
import org.example.carmarketplace.Repositories.FuelTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypeService {
    private final FuelTypeRepository fuelTypeRepository;

    public FuelTypeService(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }


    public List<FuelType> getAllFuelTypes(){
        return fuelTypeRepository.findAll();
    }
}
