package org.example.carmarketplace.Services;

import org.example.carmarketplace.Models.Color;
import org.example.carmarketplace.Repositories.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    private final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Optional<Color> getColorByName(String name) {
        return colorRepository.findByName(name);
    }

    public Color createColor(Color color) {
        return colorRepository.save(color);
    }

    public Optional<Color> getColorById(Long id) {
        return colorRepository.findById(id);
    }
}
