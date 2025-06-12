package org.example.carmarketplace.Services;

import org.example.carmarketplace.ENUMs.GearboxType;
import org.example.carmarketplace.ENUMs.VehicleCondition;
import org.example.carmarketplace.ENUMs.VehicleType;
import org.example.carmarketplace.Repositories.BrandRepository;
import org.example.carmarketplace.Repositories.ColorRepository;
import org.example.carmarketplace.Repositories.ComfortFeaturesRepository;
import org.example.carmarketplace.Repositories.FuelTypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormOptionsService {
    private final BrandRepository brandRepo;
    private final FuelTypeRepository fuelRepo;
    private final ComfortFeaturesRepository comfortRepo;
    private final ColorRepository colorRepo;

    public FormOptionsService(BrandRepository brandRepo, FuelTypeRepository fuelRepo,
                              ComfortFeaturesRepository comfortRepo, ColorRepository colorRepo) {
        this.brandRepo = brandRepo;
        this.fuelRepo = fuelRepo;
        this.comfortRepo = comfortRepo;
        this.colorRepo = colorRepo;
    }

    public Map<String, Object> getPublicationFormOptions() {
        Map<String, Object> map = new HashMap<>();

        map.put("brands", brandRepo.findAll());
        map.put("fuelTypes", fuelRepo.findAll());
        map.put("comfortFeatures", comfortRepo.findAll());
        map.put("colors", colorRepo.findAll());


        map.put("vehicleConditions", List.of(VehicleCondition.values()));
        map.put("vehicleTypes", List.of(VehicleType.values()));
        map.put("gearboxTypes", List.of(GearboxType.values()));

        return map;
    }
}
