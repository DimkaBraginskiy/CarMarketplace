package org.example.carmarketplace.Controllers;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleResponseDto;
import org.example.carmarketplace.Services.FormOptionsService;
import org.example.carmarketplace.Services.PublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationService publicationService;
    private final FormOptionsService formOptionsService;

    public PublicationController(PublicationService publicationService, FormOptionsService formOptionsService) {
        this.publicationService = publicationService;
        this.formOptionsService = formOptionsService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("dto", new PublicationVehicleRequestDto());

        Map<String, Object> formOptions = formOptionsService.getPublicationFormOptions();


        if (!formOptions.containsKey("gearboxTypes") || formOptions.get("gearboxTypes") == null) {
            System.err.println("gearboxTypes is MISSING OR NULL");
        } else {
            System.out.println("gearboxTypes = " + formOptions.get("gearboxTypes"));
        }

        model.addAllAttributes(formOptions);

        return "create";
    }

    @PostMapping("/create")
    public String handleCreateForm(@ModelAttribute("dto") PublicationVehicleRequestDto dto,
                                   Principal principal) {
        String email = principal.getName();
        publicationService.createPublicationWithVehicleFromForm(dto, email);
        return "redirect:/";
    }

    @GetMapping("/my-publications")
    public String listUserPublications(Model model, Principal principal) {
        String email = principal.getName();
        List<PublicationVehicleResponseDto> dtos = publicationService.getUserPublications(email);
        model.addAttribute("publications", dtos);
        return "my-publications"; // New HTML page
    }


    @PostMapping("/toggle-active/{id}")
    public String toggleActive(@PathVariable Long id, Principal principal) {
        String email = principal.getName();
        publicationService.toggleActiveStatus(id, email);
        return "redirect:/publication/my-publications";
    }


}
