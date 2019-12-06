package com.enigma.impl;

import com.enigma.dao.BoatDao;
import com.enigma.dao.FixedReaderDao;
import com.enigma.model.Boat;

import java.io.*;

public class FixedReaderDaoImpl implements FixedReaderDao {
    public static final String CREATE_BOATING_DOCK = "create_boating_dock";
    public static final String BOATING_DOCK = "dock";
    public static final String BOATING_LEAVE = "leave";
    public static final String BOATING_STATUS = "status";
    public static final String BOATING_SEARCH_NUMBER_BY_COLOUR = "registration_numbers_for_boats_with_colour";
    public static final String BOATING_SEARCH_SLOTS_NUMBER_BY_COLOUR = "slot_numbers_for_boats_with_colour";
    public static final String BOATING_SEARCH_SLOTS_NUMBER_BY_LICENSE_NUMBER = "slot_number_for_registration_number";

    private static BoatDao boatingDockDao;
    public FixedReaderDaoImpl() {
    }


    public String readLine(BufferedReader filePath) throws IOException {
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = filePath.readLine()) != null) {
            String [] array = line.trim().split("\\s+");
            builder.append(readCommand(array));
        }
        return null;
    }

    @Override
    public String readFiles(String file) throws IOException {
        File fileReader = new File(file);
        BufferedReader reader = new BufferedReader(new FileReader(fileReader));
        return readLine(reader);
    }

    public String readCommand(String[] file){
        for (int i=0; i < file.length; i++) {
            switch (file[i]) {
                case CREATE_BOATING_DOCK :
                    try {
                        Integer capacity = Integer.parseInt(file[i+1]);
                        boatingDockDao = new BoatDaoImpl(capacity);
                        System.out.println(boatingDockDao.createParkingBoat());
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("unrecognized");
                    }
                    break;
                case BOATING_DOCK :
                    try {
                        String licenseNumber = file[i+1];
                        String colour = file[i+2];
                        System.out.println(boatingDockDao.dock(new Boat(licenseNumber, colour)));

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("unrecognized");
                    }
                    break;
                case BOATING_LEAVE :
                    try {
                        Integer pierNumber = Integer.parseInt(file[i+1]);
                        System.out.println(boatingDockDao.leave(pierNumber));
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("unrecognized");
                    }
                    break;
                case BOATING_STATUS :
                    System.out.println(boatingDockDao.status());
                    break;
                case BOATING_SEARCH_NUMBER_BY_COLOUR :
                    try {
                        String searchColourOne = file[i+1];
                        System.out.println(boatingDockDao.searchLicenseNumberByColour(searchColourOne));
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("unrecognized");
                    }
                    break;
                case BOATING_SEARCH_SLOTS_NUMBER_BY_COLOUR :
                    try{
                        String searchColourTwo = file[i+1];
                        System.out.println(boatingDockDao.searchSlotPierByColour(searchColourTwo));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("unrecognized");
                    }
                    break;
                case BOATING_SEARCH_SLOTS_NUMBER_BY_LICENSE_NUMBER :
                    try {
                        String searchLicenseNumber = file[i+1];
                        System.out.println(boatingDockDao.searchSlotPierByLicenseNumber(searchLicenseNumber));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("unrecognized");
                    }
                    break;
                default:
                    break;
            }
        }
        return null;
    }
}

