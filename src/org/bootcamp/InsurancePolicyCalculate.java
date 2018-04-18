package org.bootcamp;

public final class InsurancePolicyCalculate {

    public static final InsurancePolicyCalculate INSTANCE = new InsurancePolicyCalculate();
        private InsurancePolicyCalculate() {

        }

        public int calculate(Car car) {
            int cost = 100 * car.getAge();
            cost += car.isDiesel() ? 500 : 0;
            cost += (car.getNumberOfMiles() > 200000) ? 500 : 0;
            return cost;
        }

        public int calculate(Bus bus) {
            int cost = 200 * bus.getAge();
            cost += bus.isDiesel() ? 1000 : 0;

            if (bus.getNumberOfMiles() > 100000 && bus.getNumberOfMiles() < 200000) {
                cost += 500;
            }
            if (bus.getNumberOfMiles() > 200000) {
                cost += 1000;
            }
            return cost;
        }

        public int calculate(Tipper Tipper) {
            int cost = 300 * Tipper.getAge();
            if (Tipper.getNumberOfMiles() > 80000) {
                cost += 700;
            }
            return cost;
        }

}
