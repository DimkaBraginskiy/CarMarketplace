package org.example.carmarketplace.Controllers;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.Services.PublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("dto", new PublicationVehicleRequestDto());
        return "publication/create";
    }

    @PostMapping("/create")
    public String handleCreateForm(@ModelAttribute("dto") PublicationVehicleRequestDto dto,
                                   Principal principal) {
        publicationService.createPublicationWithVehicle(dto);
        return "redirect:/"; // Or redirect to details
    }
}
