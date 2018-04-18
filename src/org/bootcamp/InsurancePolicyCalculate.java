package org.bootcamp;

public final class InsurancePolicyCalculate {

    public static final InsurancePolicyCalculate INSTANCE = new InsurancePolicyCalculate();
        private InsurancePolicyCalculate() {

        }

       public int calculate (Vehicle vehicle, Formula formula)
       {
           return formula.calculate(vehicle);
       }

}
