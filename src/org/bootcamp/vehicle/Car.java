package org.bootcamp.vehicle;

public final class Car extends Vehicle { //nu vom putea mosteni clasa respectiva cu final
    private String  transmission = "manual";

    public Car()
    {
    }

    public Car(int age, long numberOfMiles, boolean isDiesel) {
        super(age, numberOfMiles, isDiesel);
    }

    public Car(int age, long numberOfMiles, boolean isDiesel, String transmission) {
        super(age, numberOfMiles, isDiesel);
        this.transmission = transmission;
    }

    public String getTransmision() {
        return transmission;
    }

    public void setTransmision(String transmision) {
        this.transmission = transmision;
    }
}
