package org.example.carmarketplace.Repositories;

import org.example.carmarketplace.DTOs.Request.VehicleFilterDto;
import org.example.carmarketplace.Models.Publication;

import java.util.List;

public interface PublicationRepositoryCustom {
    List<Publication> advancedSearch(VehicleFilterDto filter);
}
