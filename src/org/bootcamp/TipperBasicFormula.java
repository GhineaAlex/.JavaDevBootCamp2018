package org.bootcamp;

public class TipperBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {
        int cost = 300 * vehicle.getAge();
        if (vehicle.getNumberOfMiles() > 80000) {
            cost += 700;
        }
        return cost;
    }
}
