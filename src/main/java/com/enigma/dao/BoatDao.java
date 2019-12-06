package com.enigma.dao;

import com.enigma.model.Boat;

public interface BoatDao {
    public String createParkingBoat();

    public String dock(Boat boat);

    public String leave(Integer slots);

    public String status();

    public String searchLicenseNumberByColour(String search);

    public String searchSlotPierByColour(String search);

    public String searchSlotPierByLicenseNumber(String search);
}
