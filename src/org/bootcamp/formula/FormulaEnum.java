package org.bootcamp.formula;
import org.bootcamp.vehicle.Vehicle;
public enum FormulaEnum {

    CarBasicFormula
            {
                @Override
                public int calculate(Vehicle vehicle) {
                    int cost = 100 * vehicle.getAge();
                    cost += vehicle.isDiesel() ? 500 : 0;
                    cost += vehicle.getNumberOfMiles() > 200000 ? 500 : 0;

                    return cost;
                }
            },
    BusBasicFormula
            {
                @Override
                public int calculate(Vehicle vehicle)
                {
                    int cost = 200 * vehicle.getAge();
                    cost += vehicle.isDiesel() ? 1000 : 0;

                    if (vehicle.getNumberOfMiles() > 100000 && vehicle.getNumberOfMiles() < 200000) {
                        cost += 500;
                    }
                    if (vehicle.getNumberOfMiles() > 200000) {
                        cost += 1000;
                    }
                    return cost;
                }
            },
    TipperBasicFormula {
        @Override
        public int calculate(Vehicle vehicle) {
            int cost = 300 * vehicle.getAge();
            if (vehicle.getNumberOfMiles() > 80000) {
                cost += 700;
            }
            return cost;
        }
    };
                    public abstract int calculate(Vehicle vehicle);

}
