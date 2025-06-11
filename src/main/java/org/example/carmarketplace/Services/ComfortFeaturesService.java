package org.example.carmarketplace.Services;

import org.example.carmarketplace.Repositories.ComfortFeaturesRepository;
import org.springframework.stereotype.Service;

@Service
public class ComfortFeaturesService {
    private final ComfortFeaturesRepository comfortFeaturesRepository;

    public ComfortFeaturesService(ComfortFeaturesRepository comfortFeaturesRepository) {
        this.comfortFeaturesRepository = comfortFeaturesRepository;
    }
}
