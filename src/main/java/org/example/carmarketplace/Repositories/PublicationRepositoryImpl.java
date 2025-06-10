package org.example.carmarketplace.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.example.carmarketplace.DTOs.Request.VehicleFilterDto;
import org.example.carmarketplace.Models.Publication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PublicationRepositoryImpl implements PublicationRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    private VehicleFilterDto filter;

    @Override
    public List<Publication> advancedSearch(VehicleFilterDto filter) {
        this.filter = filter;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Publication> query = cb.createQuery(Publication.class);
        Root<Publication> pub = query.from(Publication.class);

        Join<?, ?> vehicle = pub.join("vehicle");
        Join<?, ?> brand = vehicle.join("brand", JoinType.LEFT);
        Join<?, ?> color = vehicle.join("color", JoinType.LEFT);
        Join<?, ?> fuel = vehicle.join("fuelTypes", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.isTrue(pub.get("isActive")));

        if (filter.getVehicleType() != null)
            predicates.add(cb.equal(vehicle.get("vehicleType"), filter.getVehicleType()));
        if (filter.getBrandId() != null)
            predicates.add(cb.equal(brand.get("id"), filter.getBrandId()));
        if (filter.getFuelTypeId() != null)
            predicates.add(cb.equal(fuel.get("id"), filter.getFuelTypeId()));
        if (filter.getColorId() != null)
            predicates.add(cb.equal(color.get("id"), filter.getColorId()));
        if (filter.getCondition() != null)
            predicates.add(cb.equal(vehicle.get("condition"), filter.getCondition()));
        if (filter.getGearboxType() != null)
            predicates.add(cb.equal(vehicle.get("gearboxType"), filter.getGearboxType()));
        if (filter.getYearFrom() != null)
            predicates.add(cb.greaterThanOrEqualTo(vehicle.get("year"), filter.getYearFrom()));
        if (filter.getYearTo() != null)
            predicates.add(cb.lessThanOrEqualTo(vehicle.get("year"), filter.getYearTo()));
        if (filter.getHpFrom() != null)
            predicates.add(cb.greaterThanOrEqualTo(vehicle.get("horsePower"), filter.getHpFrom()));
        if (filter.getHpTo() != null)
            predicates.add(cb.lessThanOrEqualTo(vehicle.get("horsePower"), filter.getHpTo()));
        if (filter.getKeyword() != null && !filter.getKeyword().isBlank()) {
            String kw = "%" + filter.getKeyword().toLowerCase() + "%";
            predicates.add(cb.or(
                    cb.like(cb.lower(vehicle.get("engineName")), kw),
                    cb.like(cb.lower(pub.get("description")), kw),
                    cb.like(cb.lower(brand.get("name")), kw)
            ));
        }

        query.select(pub).distinct(true).where(cb.and(predicates.toArray(new Predicate[0])));
        return em.createQuery(query).getResultList();
    }
}