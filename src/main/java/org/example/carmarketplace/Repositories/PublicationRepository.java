package org.example.carmarketplace.Repositories;

import org.example.carmarketplace.Models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByIsActiveTrue();


    @Query("""
       SELECT p FROM Publication p 
       JOIN p.vehicle v 
       JOIN v.brand b 
       WHERE p.isActive = true AND (
           LOWER(b.name) LIKE %:keyword% OR 
           LOWER(v.engineName) LIKE %:keyword% OR 
           LOWER(p.description) LIKE %:keyword% OR 
           STR(v.color.name) LIKE %:keyword% OR 
           STR(v.gearboxType) LIKE %:keyword%
       )
       """)
    List<Publication> findByKeyword(@Param("keyword") String keyword);
}
