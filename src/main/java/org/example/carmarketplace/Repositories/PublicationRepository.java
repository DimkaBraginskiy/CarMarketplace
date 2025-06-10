package org.example.carmarketplace.Repositories;

import org.example.carmarketplace.ENUMs.VehicleType;
import org.example.carmarketplace.Models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>, PublicationRepositoryCustom {
    List<Publication> findByIsActiveTrue();


    @Query("""
    SELECT p FROM Publication p 
    JOIN p.vehicle v 
    JOIN v.brand b 
    WHERE p.isActive = true
    AND (:vehicleType IS NULL OR v.vehicleType = :vehicleType)
    AND (
        :keyword IS NULL OR :keyword = '' OR (
            LOWER(b.name) LIKE %:keyword% OR 
            LOWER(v.engineName) LIKE %:keyword% OR 
            LOWER(p.description) LIKE %:keyword% OR 
            LOWER(v.color.name) LIKE %:keyword%
        )
    )
""")
    List<Publication> searchByKeywordAndVehicleType(
            @Param("keyword") String keyword,
            @Param("vehicleType") VehicleType vehicleType);
}
