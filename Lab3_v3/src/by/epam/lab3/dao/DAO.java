package by.epam.lab3.dao;

import by.epam.lab3.entity.Aircraft;
import by.epam.lab3.entity.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class DAO {
    private static final Logger log = LogManager.getLogger();
    private static final String PATH_DIR = "data";
    private static final String PATH_AIRCRAFTS = PATH_DIR + File.separator + "aircrafts.txt";
    private static final String PATH_OWNERS = PATH_DIR + File.separator + "owners.txt";

    private static ArrayList<Aircraft> getAircrafts() {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_AIRCRAFTS))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String str;
            for (int i = 0; i < n; ++i) {
                Aircraft aircraft = new Aircraft();
                str = bufferedReader.readLine();
                aircraft.setName(str);
                str = bufferedReader.readLine();
                aircraft.setPrice(Integer.parseInt(str));
                str = bufferedReader.readLine();
                aircraft.setCapacity(Integer.parseInt(str));
                aircrafts.add(aircraft);
            }
        } catch (IOException e) {
            log.error(e);
        }
        return aircrafts;
    }

    private static ArrayList<Owner> getOwners(ArrayList<Aircraft> aircrafts) {
        ArrayList<Owner> owners = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_OWNERS))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String str;
            for (int i = 0; i < n; ++i) {
                Owner owner = new Owner();
                str = bufferedReader.readLine();
                owner.setName(str);
                str = bufferedReader.readLine();
                owner.setLocation(str);
                int m = Integer.parseInt(bufferedReader.readLine());
                for (int j = 0; j < m; ++j) {
                    str = bufferedReader.readLine();
                    for (Aircraft aircraft : aircrafts) {
                        if (aircraft.getName().equals(str)) {
                            owner.addAircraft(aircraft);
                            aircraft.addOwner(owner);
                        }
                    }
                }
                owners.add(owner);
            }
        } catch (IOException e) {
            log.error(e);
        }
        return owners;
    }

    public static void getData(ArrayList<Owner> owners, ArrayList<Aircraft> aircrafts) {
        aircrafts.addAll(getAircrafts());
        owners.addAll(getOwners(aircrafts));
    }
}
