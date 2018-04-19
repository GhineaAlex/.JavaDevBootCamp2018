package org.bootcamp;

import org.bootcamp.calculate.InsurancePolicyCalculate;
import org.bootcamp.formula.Formula;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;

import org.bootcamp.formula.FormulaEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

    if(args.length >= 1)
    {
        final File inputFile = new File (args[0]);
        try {
            final InputStream inputStream = new FileInputStream(inputFile);
            final Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }
            catch(FileNotFoundException noFileFound)
            {
                System.out.println(noFileFound.getMessage());
            }
    }
        else {
        System.out.println("Fara argumente");
    }
    }
}
