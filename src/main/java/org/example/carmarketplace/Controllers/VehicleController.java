package org.example.carmarketplace.Controllers;

import org.example.carmarketplace.DTOs.Response.PublicationVehicleDetailedResponseDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleResponseDto;
import org.example.carmarketplace.Mappers.PublicationMapper;
import org.example.carmarketplace.Models.Publication;
import org.example.carmarketplace.Services.PublicationService;
import org.example.carmarketplace.Services.VehicleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;
    private final PublicationService publicationService;

    public VehicleController(VehicleService vehicleService, PublicationService publicationService) {
        this.vehicleService = vehicleService;
        this.publicationService = publicationService;
    }

    @GetMapping("/vehicle/{id}")
    public String viewVehicleDetails(@PathVariable Long id, Model model) {
        Publication pub = publicationService.getPublicationById(id);
        PublicationVehicleDetailedResponseDto dto = PublicationMapper.toDetailedDto(pub);
        model.addAttribute("vehicle", dto);
        return "vehicle-details";
    }

    @GetMapping("/vehicle/image/{id}")
    public ResponseEntity<byte[]> getVehicleImage(@PathVariable Long id) {
        byte[] imageData = vehicleService.getVehicleImageById(id);
        if (imageData == null) return ResponseEntity.notFound().build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Adjust based on format
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }


}
