package com.enigma.impl;

import com.enigma.constanta.MessageConstant;
import com.enigma.dao.BoatDao;
import com.enigma.model.Boat;
import org.junit.Assert;
import org.junit.Test;


public class BoatDaoImplTest {

    @Test
    public void createParkingBoat_should_able_to_create_when_given_capacity_one() {
        Integer expectedCapacity = 1;
        Integer expectedSlot = 1;
        String expectedStringResult = String.format(MessageConstant.CREATE_PIER_SLOT,expectedSlot);
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        boatingDockDao.createParkingBoat();
        String actualStringResult = boatingDockDao.createParkingBoat();
        Assert.assertEquals(expectedStringResult, actualStringResult);

    }

    @Test
    public void dock_should_able_to_parking_of_boat_when_given_one_capacity() {
        Integer expectedSlot = 1;
        Integer expectedCapacity = 1;
        String expectedStringResult = String.format(MessageConstant.PARKING_BOAT_SUCCES, expectedSlot);
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        boatingDockDao.createParkingBoat();
        Boat boat = new Boat("KA-01HH-2056", "Blue");
        String actualStringResult = boatingDockDao.dock(boat);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void dock_should_return_message_is_full_when_parking_slot_is_empty(){
        Integer expectedSlot = 1;
        Integer expectedCapacity = 1;
        String expectedStringResult = String.format(MessageConstant.PARKING_BOAT_FULL, expectedSlot);
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        Boat boatOne = new Boat("KA-02HH-2087","Black");
        Boat boatTwo = new Boat("KA-05TT-2011", "White");
        boatingDockDao.dock(boatOne);
        String actualStringResult = boatingDockDao.dock(boatTwo);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void dock_should_not_be_able_to_dock_when_lincense_number_and_colour_is_same() {
        Integer expectedCapacity = 2;
        String expectedStringResult = MessageConstant.PARKING_BOAT_FAIL;
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        Boat boatOne = new Boat("KA-02JJ-2098", "Blue");
        Boat boatTwo = new Boat("KA-02JJ-2098", "Blue");
        boatingDockDao.dock(boatOne);
        String actualStringResult = boatingDockDao.dock(boatTwo);
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void leave_should_return_num_of_available_slot() {
        Integer expectedSlot = 1;
        Integer expectedcapacity = 1;

        BoatDao boatingDockDao = new BoatDaoImpl(expectedcapacity);
        boatingDockDao.createParkingBoat();
        Boat boatOne = new Boat("KA-02II-9876", "Red");
        String expectedStringResult = String.format(MessageConstant.BOATING_LEAVE_SUCCES, expectedSlot);
        boatingDockDao.dock(boatOne);
        String actualStringResult = boatingDockDao.leave(boatOne);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void leave_should_return_message_licenseNumber_not_found(){
        Integer expectedCapacity = 1;
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        Boat boatOne = new Boat("K 45231 Q");
        Boat boatTwo = new Boat("L 362487 H");
        String expectedStringResult = String.format(MessageConstant.NOT_FOUND);
        boatingDockDao.createParkingBoat();
        boatingDockDao.dock(boatOne);
        String actualStringResult = boatingDockDao.leave(boatTwo);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void status_should_return_description_of_docking_status_when_given_one_capacity() {
        StringBuilder builder = new StringBuilder();
        Integer expectedSlot = 1;
        Integer expectedCapacity = 1;
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        Boat boatOne = new Boat("KH-08879-JGJ", "White");
        boatingDockDao.createParkingBoat();
        boatingDockDao.dock(boatOne);
        builder.append(MessageConstant.HEADER_STATUS).toString();
        builder.append(String.format(MessageConstant.RECORD_STATUS, expectedSlot, boatOne.getLicenseNumber(), boatOne.getColour()));
        String expectedStringResult = builder.toString();
        String actualStringResult = boatingDockDao.status();
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void search_should_return_get_license_number_by_search_with_colour() {
        Integer expectedSLot = 3;
        Integer expectedCapacity = 3;
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        Boat boatOne = new Boat("KH-0182-TH", "White");
        Boat boatTwo = new Boat("HKHK-IHIS", "White");
        Boat boatThree = new Boat("HKHK-2382", "White");
        boatingDockDao.createParkingBoat();
        boatingDockDao.dock(boatOne);
        boatingDockDao.dock(boatTwo);
        boatingDockDao.dock(boatThree);
        String expectedStringResult = String.format(MessageConstant.SEARCH_NUMBER_BY_COLOUR, boatOne.getLicenseNumber());
        String actualStringResult = boatingDockDao.search("White");
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void search_should_return_get_slot_by_search_with_colour() {
        Integer expectedSLot = 3;
        Integer expectedCapacity = 3;
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        Boat boatOne = new Boat("KH-0182-TH", "White");
        Boat boatTwo = new Boat("HKHK-IHIS", "White");
        Boat boatThree = new Boat("HKHK-2382", "White");
        boatingDockDao.createParkingBoat();
        boatingDockDao.dock(boatOne);
        boatingDockDao.dock(boatTwo);
        boatingDockDao.dock(boatThree);
        String expectedStringResult = String.format(MessageConstant.SEARCH_SLOT_BY_COLOUR, expectedSLot);
        String actualStringResult = boatingDockDao.search("HKHK-2382");
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void search_should_return_get_slot_by_search_with_licenseNumber() {
        Integer expectedSLot = 1;
        Integer expectedCapacity = 3;
        BoatDao boatingDockDao = new BoatDaoImpl(expectedCapacity);
        Boat boatOne = new Boat("KH-0182-TH", "White");
        Boat boatTwo = new Boat("HKHK-IHIS", "White");
        Boat boatThree = new Boat("HKHK-2382", "White");
        boatingDockDao.createParkingBoat();
        boatingDockDao.dock(boatOne);
        boatingDockDao.dock(boatTwo);
        boatingDockDao.dock(boatThree);
        String expectedStringResult = String.format(MessageConstant.SEARCH_SLOT_BY_NUMBER, expectedSLot);
        String actualStringResult = boatingDockDao.search("KH-0182-TH");
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }
}