package org.bootcamp.calculate;

import org.bootcamp.formula.FormulaEnum;
import org.bootcamp.vehicle.Vehicle;


public class InsurancePolicyCalculate {
        public static final InsurancePolicyCalculate INSTANCE = new InsurancePolicyCalculate();

        private InsurancePolicyCalculate() {

        }

        public int calculate(Vehicle vehicle, FormulaEnum formula) {
            return formula.calculate(vehicle);
        }


}
