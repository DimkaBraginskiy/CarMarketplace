package org.example.carmarketplace.ENUMs;

public enum GearboxType {
    MECHANICAL,
    AUTOMATIC,
    STRAIGHT_CUT,
    SEMI_AUTOMATIC;

    @Override
    public String toString() {
        return name(); // DO NOT include any prefix like "GearboxType: "
    }
}
