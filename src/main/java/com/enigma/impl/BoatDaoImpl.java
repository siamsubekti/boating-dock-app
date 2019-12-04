package com.enigma.impl;

import com.enigma.constanta.MessageConstant;
import com.enigma.dao.BoatDao;
import com.enigma.model.Boat;

import java.util.HashMap;
import java.util.Map;

public class BoatDaoImpl implements BoatDao {
    private Integer capacity;
    Map<Integer, Boat> pierSlots = new HashMap<>();

    public BoatDaoImpl(Integer capacity){
        this.capacity = capacity;
    }

    public String createParkingBoat() {
        for (int slot=1; slot <= this.capacity; slot++) {
            pierSlots.put(slot, null);
        }
        return String.format(MessageConstant.CREATE_PIER_SLOT, this.capacity);
    }

    public String dock(Boat boat) {
        if (pierSlots.containsValue(boat)){
            return MessageConstant.PARKING_BOAT_FAIL;
        }for (int slot=1; slot <= this.capacity; slot++){
            if (pierSlots.get(slot) == null) {
                pierSlots.put(slot, boat);
                return String.format(MessageConstant.PARKING_BOAT_SUCCES, slot);
            }
        }
        return MessageConstant.PARKING_BOAT_FULL;
    }

    public String leave(Boat boat) {
        for (Map.Entry<Integer, Boat> slot : pierSlots.entrySet()) {
            if (slot.getValue() != null) {
                Boat selectedBoat = slot.getValue();
                if (boat.getLicenseNumber().equals(selectedBoat.getLicenseNumber())) {
                    pierSlots.put(slot.getKey(), null);
                    return String.format(MessageConstant.BOATING_LEAVE_SUCCES, slot.getKey());
                }
            }
        }
        return MessageConstant.NOT_FOUND;
    }

    public String status() {
        StringBuilder builder = new StringBuilder();
        builder.append(MessageConstant.HEADER_STATUS);
        for (Map.Entry<Integer, Boat> slot : pierSlots.entrySet()) {
            if (slot.getValue() != null) {
                builder.append(String.format(MessageConstant.RECORD_STATUS, slot.getKey(), slot.getValue().getLicenseNumber(), slot.getValue().getColour()));
            }
        }
        return builder.toString();
    }

    public String search(String search) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Boat> slot : pierSlots.entrySet()) {
            if (slot.getValue() != null) {
                if (slot.getValue().getColour().equals(search)) {
                    return builder.append(String.format(MessageConstant.SEARCH_NUMBER_BY_COLOUR, slot.getValue().getLicenseNumber())+",").toString();
                } else if (slot.getValue().getColour().equals(search)) {
                    return String.format(MessageConstant.SEARCH_SLOT_BY_COLOUR, slot.getKey());
                } else if (slot.getValue().getLicenseNumber().equals(search)) {
                    return String.format(MessageConstant.SEARCH_SLOT_BY_NUMBER, slot.getKey());
                }
            }
        }
        return MessageConstant.NOT_FOUND;
    }
}
