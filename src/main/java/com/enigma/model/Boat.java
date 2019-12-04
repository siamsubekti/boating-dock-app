package com.enigma.model;

import java.util.Objects;

public class Boat {
    private String licenseNumber;

    private String colour;

    public Boat(String licenseNumber, String colour) {
        this.licenseNumber = licenseNumber;
        this.colour = colour;
    }

    public Boat(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boat boat = (Boat) o;
        return licenseNumber.equals(boat.licenseNumber) &&
                colour.equals(boat.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseNumber, colour);
    }
}
