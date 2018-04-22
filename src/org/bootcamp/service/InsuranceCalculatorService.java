package org.bootcamp.service;

import org.bootcamp.calculate.InsurancePolicyCalculate;
import org.bootcamp.dao.VehicleDao;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.FormulaEnum;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Vehicle;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.bootcamp.service.ConversionUtils.getVehicle;

public final class InsuranceCalculatorService {
    private String filePath;

    public InsuranceCalculatorService(String filePath) {
        this.filePath = filePath;
    }

    public List<InsuranceCalculationResult> calculateAll() {
        final InsurancePolicyCalculate calculator = InsurancePolicyCalculate.INSTANCE;

        final VehicleDao vehicleInfoDao = new VehicleInfoPlainFileDao(this.filePath);

        final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();

        final List<InsuranceCalculationResult> resultList = new LinkedList<>();

        if (vehicleInfos.isEmpty()) {
            return Collections.emptyList();
        } else {
            for (VehicleInfo info : vehicleInfos) {

                final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(),
                        info.getNumberOfMiles(), info.isDiesel());

                final FormulaEnum formula = FormulaEnum.valueOf(info.getVehicleTypeFormula());

                final int totalCost = calculator.calculate(vehicle, formula);

                final InsuranceCalculationResult result = new InsuranceCalculationResult(info.getId(), totalCost);

                resultList.add(result);

            }

            return resultList;
        }

    }

}
