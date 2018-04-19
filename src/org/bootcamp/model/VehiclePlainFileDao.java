package org.bootcamp.model;

import org.bootcamp.formula.FormulaEnum;
import org.bootcamp.vehicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;

public class VehiclePlainFileDao {
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_FORMULA = 2;

    private String filePath;

    public VehiclePlainFileDao(String filePath) {
        this.filePath = filePath;
    }

    public List<VehicleInfo> getAllVehicles() {
        List<VehicleInfo> aux;



        while (Scanner.hasNextLine()) {
            final String line = Scanner.nextLine();
            String SEPARATOR = ";";

            final String[] tokens = line.split(SEPARATOR);

            //final String line = scanner.nextLine();
            // final String[] tokens = line.split(";");

            final Vehicle vehicle = getVehicle(tokens[VEHICLE_TYPE], Integer.parseInt(tokens[VEHICLE_AGE]),
                    Long.parseLong(tokens[VEHICLE_MILES]), Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));

            final FormulaEnum formula = FormulaEnum.valueOf(tokens[2]);

        }
    }
}