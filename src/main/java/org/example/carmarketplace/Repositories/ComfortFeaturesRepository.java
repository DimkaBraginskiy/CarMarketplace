package org.example.carmarketplace.Repositories;

import org.example.carmarketplace.Models.ComfortFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComfortFeaturesRepository extends JpaRepository<ComfortFeatures, Long> {
}
