package service;
import java.util.LinkedList;
import java.util.List;

import org.bootcamp.calculate.InsurancePolicyCalculate;
import service.InsuranceCalculationResult;
import org.bootcamp.model.VehicleDao;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.model.VehiclePlainFileDao;

public final class InsuranceCalculatorService {
    private String filePath;

    public InsuranceCalculatorService(String filePath){
        this.filePath = filePath;
    }

    public List<InsuranceCalculationResult> calculateAll(){

        final InsurancePolicyCalculate calculator = InsurancePolicyCalculate.INSTANCE;
        final VehicleDao vehicleInfoDao = new VehiclePlainFileDao(this.filePath);

        final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();
        final List<InsuranceCalculationResult>  resultList = new LinkedList<>();

        if(vehicleInfo)
    }
}
