package org.bootcamp.dao;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bootcamp.model.VehicleInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public final class VehicleInfoExcelFileDao implements VehicleInfoDao {

   // private final Map<String, VehicleInfo> vehicleInfoMap;

    private static final int EXCEL_INFORMATION_SHEET = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_FORMULA = 2;
    private String filePath;
    Map<String, VehicleInfo> vehicleInfoMap = new HashMap<>();

    public VehicleInfoExcelFileDao(String filePath) {
        this.filePath = filePath;
        try {
            final FileInputStream inputStream = new FileInputStream(filePath);
            final Workbook workbook = new XSSFWorkbook(inputStream);
            final Sheet datatypeSheet = workbook.getSheetAt(EXCEL_INFORMATION_SHEET);
            final Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                final VehicleInfo.Builder builder = VehicleInfo.builder();
                final VehicleInfo vehicle = builder.withId(cellIterator.next().getStringCellValue())

                        .withVehicleTypeName(cellIterator.next().getStringCellValue())

                        .withVehicleTypeFormula(cellIterator.next().getStringCellValue())

                        .withAge((int)cellIterator.next().getNumericCellValue())

                        .withNumberOfMiles((int)cellIterator.next().getNumericCellValue())

                        .withIsDiesel(cellIterator.next().getBooleanCellValue()).build();

                vehicleInfoMap.put(vehicle.getId(), vehicle);
            }

        } catch (FileNotFoundException er) {
            throw new IllegalStateException("Can not create instance of class VehicleExcelFileDao" + VehicleInfoExcelFileDao.class.getSimpleName());
        } catch (IOException er) {
            throw new IllegalStateException("Can not create instance of class VehicleExcelFileDao" );
        }
    }
        @Override
        public List<VehicleInfo> getAllVehicles() {
            /*List<VehicleInfo> vehicleInfoList = new ArrayList<>();
            List<VehicleInfo> vehicleInfos = new ArrayList<>();

            vehicleInfoMap.forEach((key, vehicleInfo) -> vehicleInfos.add(vehicleInfo));

            return vehicleInfos;*/
            return new ArrayList<>(vehicleInfoMap.values());
        }

        @Override

        public VehicleInfo getVehicleInfoById(String id) {

            return vehicleInfoMap.get(id);
        }
}

