package org.bootcamp.service;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.dao.VehicleInfoExcelFileDao;
import org.bootcamp.dao.VehicleInfoJsonFileDao;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Vehicle;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.bootcamp.service.ConversionUtils.getVehicle;

public final class InsuranceCalculatorService {
    private String filePath;
    private final VehicleInfoDao vehicleInfoD;

    public InsuranceCalculatorService(String filePath) {
        this.vehicleInfoD = new VehicleInfoExcelFileDao(filePath);
    }

    public List<InsuranceCalculationResult> calculateAll() {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        //final VehicleInfoDao vehicleInfoDao = new VehicleInfoPlainFileDao(this.filePath);

        final List<VehicleInfo> vehicleInfos = vehicleInfoD.getAllVehicles();

        final List<InsuranceCalculationResult> resultList = new LinkedList<>();

        if (vehicleInfos.isEmpty()) {
            return Collections.emptyList();
        } else {
            for (VehicleInfo info : vehicleInfos) {

                final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(),
                        info.getNumberOfMiles(), info.isDiesel());

                final Formula formula = Formula.valueOf(info.getVehicleTypeFormula());

                final int totalCost = calculator.calculate(vehicle, formula);

                final InsuranceCalculationResult result = new InsuranceCalculationResult(info.getId(), totalCost, info.getVehicleTypeName());

                resultList.add(result);

            }

            return resultList;
        }

    }

    public InsuranceCalculationResult calculateById(String id) {

        final InsurancePolicyCalculator calc = InsurancePolicyCalculator.INSTANCE;
        final VehicleInfo vehicleInfo = vehicleInfoD.getVehicleInfoById(id);

        final Vehicle vehicle = getVehicle(vehicleInfo.getVehicleTypeName(), vehicleInfo.getAge(), vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
        final Formula formula = Formula.valueOf(vehicleInfo.getVehicleTypeFormula());
        final int total = calc.calculate(vehicle, formula);

        InsuranceCalculationResult result = new InsuranceCalculationResult(vehicleInfo.getId(), total, vehicleInfo.getVehicleTypeName());

        return result;
    }

    public List<InsuranceCalculationResult>  getCostsHigherThan(int cost){

       List<InsuranceCalculationResult> calculationResults = this.calculateAll();
        Iterator<InsuranceCalculationResult> iterator = calculationResults.iterator();

        while(iterator.hasNext()){
            InsuranceCalculationResult result = iterator.next();
            if (result.getCost() < cost) {
                iterator.remove();
            }
        }
        return calculationResults;

    }

}
