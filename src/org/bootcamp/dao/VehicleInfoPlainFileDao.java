package org.bootcamp.dao;

import org.bootcamp.model.VehicleInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public final class VehicleInfoPlainFileDao implements VehicleInfoDao {

    private static final String SEPARATOR = ";";

    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_FORMULA = 2;

    private final VehicleInfo.Builder vehicleInfoBuilder = VehicleInfo.builder();
    private Map<String, VehicleInfo> vehicleInfoMap;
    //private final String filePath;

    public VehicleInfoPlainFileDao(String filePath) {

        vehicleInfoMap = new HashMap<>();
      VehicleInfo vehicleInfo = null;
        try {

            //final VehicleInfo.Builder builder = VehicleInfo.Builder();
            //final VehicleInfo.Builder vehicleBuilder = VehicleInfo.Builder();
            final File inputFile = new File(filePath);
            final InputStream inputStream = new FileInputStream(inputFile);
            final Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {

                final String line = scanner.nextLine();
                final String[] tokens = line.split(SEPARATOR);
               //vehicleInfo = VehicleInfo.builder();
                vehicleInfo = vehicleInfoBuilder.withId(tokens[VEHICLE_ID]).withVehicleTypeName(tokens[VEHICLE_TYPE]).withVehicleTypeFormula(tokens[VEHICLE_FORMULA])
                        .withAge(Integer.parseInt(tokens[VEHICLE_AGE])).withNumberOfMiles(Long.parseLong(tokens[VEHICLE_MILES])).withIsDiesel(Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL])).build();
                //final VehicleInfo vehicleInfo = builder.build();

                vehicleInfoMap.put(vehicleInfo.getId(), vehicleInfo);
            }
            scanner.close();
        }
            catch (FileNotFoundException er) {
                    throw new IllegalStateException("Cannot create instance of class: " + VehicleInfoPlainFileDao.class.getSimpleName() );
            }
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {
        List<VehicleInfo> vehicleInfoList = new ArrayList<>();
        List<VehicleInfo> vehicleInfos = new ArrayList<>();

        vehicleInfoMap.forEach((key, vehicleInfo) -> vehicleInfos.add(vehicleInfo));

        return vehicleInfos;
    }

    @Override
    public VehicleInfo getVehicleInfoById(String id) {

        return vehicleInfoMap.get(id);
    }
}
