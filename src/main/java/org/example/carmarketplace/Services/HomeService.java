package org.example.carmarketplace.Services;

import org.example.carmarketplace.ENUMs.VehicleCondition;
import org.example.carmarketplace.ENUMs.VehicleType;
import org.example.carmarketplace.Repositories.BrandRepository;
import org.example.carmarketplace.Repositories.ColorRepository;
import org.example.carmarketplace.Repositories.FuelTypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomeService {

    private final BrandRepository brandRepo;
    private final ColorRepository colorRepo;
    private final FuelTypeRepository fuelRepo;

    public HomeService(BrandRepository brandRepo, ColorRepository colorRepo, FuelTypeRepository fuelRepo) {
        this.brandRepo = brandRepo;
        this.colorRepo = colorRepo;
        this.fuelRepo = fuelRepo;
    }

    public Map<String, Object> getHomePageAttributes() {
        Map<String, Object> modelAttributes = new HashMap<>();
        modelAttributes.put("brands", brandRepo.findAll());
        modelAttributes.put("colors", colorRepo.findAll());
        modelAttributes.put("fuelTypes", fuelRepo.findAll());
        modelAttributes.put("vehicleTypes", VehicleType.values());
        modelAttributes.put("vehicleConditions", VehicleCondition.values());
        return modelAttributes;
    }
}
