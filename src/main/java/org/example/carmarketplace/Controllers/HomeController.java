package org.example.carmarketplace.Controllers;

import org.example.carmarketplace.DTOs.Response.PublicationVehicleResponseDto;
import org.example.carmarketplace.Mappers.PublicationMapper;
import org.example.carmarketplace.Models.Publication;
import org.example.carmarketplace.Models.Vehicle;
import org.example.carmarketplace.Services.PublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private final PublicationService publicationService;

    public HomeController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<Publication> publications = publicationService.getAllActivePublications();

        List<PublicationVehicleResponseDto> dtos = publications.stream()
                .map(PublicationMapper::toCardDto)
                .toList();

        model.addAttribute("publications", dtos);
        return "home";
    }



    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}
