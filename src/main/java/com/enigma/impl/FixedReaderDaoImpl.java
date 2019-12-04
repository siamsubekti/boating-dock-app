package com.enigma.impl;

import com.enigma.dao.BoatDao;
import com.enigma.dao.FixedReaderDao;
import com.enigma.model.Boat;

import java.io.BufferedReader;
import java.io.IOException;

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

    @Override
    public String read(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String text = bufferedReader.readLine();

            if (text == null)
                break;
            String [] array = text.trim().split("\\s+");

            for (int i=0; i < array.length; i++) {
                switch (array[i]) {
                    case CREATE_BOATING_DOCK :
                        Integer capacity = Integer.parseInt(array[i+1]);
                        boatingDockDao = new BoatDaoImpl(capacity);
                        System.out.println(boatingDockDao.createParkingBoat());
                        break;
                    case BOATING_DOCK :
                        String licenseNumber = array[i+1];
                        String colour = array[i+2];
                        System.out.println(boatingDockDao.dock(new Boat(licenseNumber, colour)));
                        break;
                    case BOATING_LEAVE :
                        String pierNumber = array[i+1];
                        System.out.println(boatingDockDao.leave(new Boat(pierNumber)));
                        break;
                    case BOATING_STATUS :
                        System.out.println(boatingDockDao.status());
                        break;
                    case BOATING_SEARCH_NUMBER_BY_COLOUR :
                        String searchColourOne = array[i+1];
                        System.out.println(boatingDockDao.search(searchColourOne));
                        break;
                    case BOATING_SEARCH_SLOTS_NUMBER_BY_COLOUR :
                        String searchColourTwo = array[i+1];
                        System.out.println(boatingDockDao.search(searchColourTwo));
                        break;
                    case BOATING_SEARCH_SLOTS_NUMBER_BY_LICENSE_NUMBER :
                        String searchLicenseNumber = array[i+1];
                        System.out.println(boatingDockDao.search(searchLicenseNumber));
                        break;
                    default:
                        break;
                }
            }
        }
        return null;
    }
}

