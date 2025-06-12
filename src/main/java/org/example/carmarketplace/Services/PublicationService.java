package org.example.carmarketplace.Services;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.DTOs.Request.VehicleFilterDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleResponseDto;
import org.example.carmarketplace.ENUMs.VehicleType;
import org.example.carmarketplace.Mappers.PublicationMapper;
import org.example.carmarketplace.Models.*;
import org.example.carmarketplace.Repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PublicationService {
    private final VehicleRepository vehicleRepo;
    private final PublicationRepository publicationRepo;
    private final UserRepository userRepo;
    private final BrandRepository brandRepo;
    private final ComfortFeaturesRepository comfortRepo;
    private final ColorRepository colorRepository;
    private final FuelTypeRepository fuelRepo;
    private final PublicationMapper mapper;


    public PublicationService(VehicleRepository vehicleRepo, PublicationRepository publicationRepo, UserRepository userRepo, BrandRepository brandRepo, ComfortFeaturesRepository comfortRepo, FuelTypeRepository fuelRepo, PublicationMapper mapper, ColorRepository colorRepository) {
        this.vehicleRepo = vehicleRepo;
        this.publicationRepo = publicationRepo;
        this.userRepo = userRepo;
        this.brandRepo = brandRepo;
        this.comfortRepo = comfortRepo;
        this.fuelRepo = fuelRepo;
        this.mapper = mapper;
        this.colorRepository = colorRepository;
    }

    public void createPublicationWithVehicleFromForm(PublicationVehicleRequestDto dto, String userEmail, MultipartFile image) throws IOException {
        User owner = userRepo.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        Brand brand = brandRepo.findById(dto.getBrandId()).orElseThrow(() -> new RuntimeException("Brand not found"));
        Color color = colorRepository.findById(dto.getColorId()).orElseThrow(() -> new RuntimeException("Color not found"));

        List<ComfortFeatures> comfortFeatures = comfortRepo.findAllById(dto.getComfortFeatureIds());
        List<FuelType> fuelTypes = fuelRepo.findAllById(dto.getFuelTypeIds());

        Vehicle vehicle = mapper.toVehicle(dto, owner, brand, comfortFeatures, fuelTypes);
        vehicle.setColor(color);

        if (image != null && !image.isEmpty()) {
            vehicle.setImage(image.getBytes()); // save image as BLOB
        }

        vehicle = vehicleRepo.save(vehicle);
        Publication publication = mapper.toPublication(dto, vehicle);
        publicationRepo.save(publication);
    }

    public List<Publication> getAllActivePublications() {
        return publicationRepo.findByIsActiveTrue();
    }

    public List<Publication> searchPublications(VehicleFilterDto filter) {
        return publicationRepo.advancedSearch(filter);
    }

    public Publication getPublicationById(Long id) {
        return publicationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication not found"));
    }

    public List<PublicationVehicleResponseDto> getUserPublications(String email) {
        User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        List<Publication> publications = publicationRepo.findByVehicleOwnerId(user.getId());
        return publications.stream()
                .map(PublicationMapper::toCardDto)
                .toList();
    }

    public void toggleActiveStatus(Long publicationId, String email) {
        Publication pub = publicationRepo.findById(publicationId)
                .orElseThrow(() -> new RuntimeException("Publication not found"));

        if (!pub.getVehicle().getOwner().getEmail().equals(email)) {
            throw new SecurityException("Not your publication");
        }

        pub.setActive(!pub.isActive());
        publicationRepo.save(pub);
    }
}
