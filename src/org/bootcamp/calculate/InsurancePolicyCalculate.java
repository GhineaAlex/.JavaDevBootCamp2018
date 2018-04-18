package org.bootcamp.calculate;

import org.bootcamp.formula.Formula;
import org.bootcamp.vehicle.Vehicle;

public final class InsurancePolicyCalculate {

    public static final InsurancePolicyCalculate INSTANCE = new InsurancePolicyCalculate();
        private InsurancePolicyCalculate() {

        }

       public int calculate (Vehicle vehicle, Formula formula)
       {
           return formula.calculate(vehicle);
       }

}
