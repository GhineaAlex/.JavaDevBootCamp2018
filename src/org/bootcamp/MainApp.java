package org.bootcamp;

import org.bootcamp.model.VehicleDao;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.model.VehiclePlainFileDao;
import org.bootcamp.vehicle.Vehicle;
import org.bootcamp.calculate.InsurancePolicyCalculate;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.model.VehicleDao;
import org.bootcamp.model.VehiclePlainFileDao;
import org.bootcamp.formula.FormulaEnum;
import service.InsuranceCalculationResult;
import service.InsuranceCalculatorService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static final String SEPARATOR  = ";";
   private static final String OUTPUT_FORMAT = "Vehicle with id%s has total cost %d";

    public static void main(String[] args) {
    final InsurancePolicyCalculate calculate = InsurancePolicyCalculate.INSTANCE;
  /*      if(args.length >= 1)
        {
            {
                final int totalCost = .calculate(vehicle, formula);

                // final String output = String.format("Vehicle with id %s has total cost %d", tokens[0], totalCost);

                System.out.println(OUTPUT_FORMAT);
            }
            while (Scanner.hasNextLine()) {
                System.out.println(Scanner.nextLine());
            }
            Scanner.close();

            catch(FileNotFoundException noFileFound)
            {
                System.out.println(noFileFound.getMessage());
            }

        else {
             System.out.println("Fara argumente");
            }
/*
 */
        if(args.length >=1)
        {
            final InsuranceCalculatorService = new InsuranceCalculatorService(args[0]);
            final List<InsuranceCalculationResult> resultList = InsuranceCalculationResult.calculateAll();

            for(InsuranceCalculationResult result : resultList)
            {
                final String output = String.format(OUTPUT_FORMAT, result.getid())
            }
        }
}
