package org.example.carmarketplace.Controllers;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.DTOs.Request.VehicleFilterDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleResponseDto;
import org.example.carmarketplace.ENUMs.VehicleCondition;
import org.example.carmarketplace.ENUMs.VehicleType;
import org.example.carmarketplace.Mappers.PublicationMapper;
import org.example.carmarketplace.Models.Publication;
import org.example.carmarketplace.Models.Vehicle;
import org.example.carmarketplace.Repositories.BrandRepository;
import org.example.carmarketplace.Repositories.ColorRepository;
import org.example.carmarketplace.Repositories.FuelTypeRepository;
import org.example.carmarketplace.Services.HomeService;
import org.example.carmarketplace.Services.PublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final PublicationService publicationService;
    private final HomeService homeService;

    public HomeController(PublicationService publicationService, HomeService homeService) {
        this.publicationService = publicationService;
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String homePage(@ModelAttribute VehicleFilterDto filter, Model model) {
        List<Publication> publications = publicationService.searchPublications(filter);
        List<PublicationVehicleResponseDto> dtos = publications.stream()
                .map(PublicationMapper::toCardDto)
                .toList();

        model.addAttribute("publications", dtos);
        model.addAttribute("filter", filter);

        Map<String, Object> homeAttributes = homeService.getHomePageAttributes();
        model.addAllAttributes(homeAttributes);

        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
