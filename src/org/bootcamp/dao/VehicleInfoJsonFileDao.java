package org.bootcamp.dao;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.bootcamp.model.VehicleInfo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class VehicleInfoJsonFileDao implements VehicleInfoDao {

    final private Map<String, VehicleInfo> vehicleInfoMap = new HashMap<>();

    public VehicleInfoJsonFileDao(String filePath){

        // this.filePath = filePath;
        final ObjectMapper objectMapper = new ObjectMapper();
        List<VehicleInfo> vehicleInfoList;
        try {

            final InputStream inputStream = new FileInputStream(new File(filePath));
            vehicleInfoList = objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, VehicleInfo.class));
            for (VehicleInfo info : vehicleInfoList) {
                vehicleInfoMap.put(info.getId(), info);
            }


        }catch (IOException er) {
            er.printStackTrace();
        }
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {

        return new ArrayList<>(vehicleInfoMap.values());
    }

    @Override
    public VehicleInfo getVehicleInfoById(String id) {

        return vehicleInfoMap.get(id);
    }

}