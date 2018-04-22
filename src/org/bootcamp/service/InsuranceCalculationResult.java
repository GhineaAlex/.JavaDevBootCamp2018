package org.bootcamp.service;


public final class InsuranceCalculationResult {
    private final String id;
    private final int cost;
    private final String vehicleType;

    public InsuranceCalculationResult(String id, int cost, String vehicleType) {
        this.id = id;
        this.cost = cost;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getVehicleType(){
        return vehicleType;
    }
}
