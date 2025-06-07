package org.example.carmarketplace.Controllers;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.Services.PublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/publication")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

//    @PostMapping
//    public ResponseEntity<String> createPublicationWithVehicle(@RequestBody PublicationVehicleRequestDto dto){
//        publicationService.createPublicationWithVehicle(dto);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body("Publication and Vehicle created successfully");
//    }
}
