package org.os;

public class Car
{
    private final int carId;
    private final int gateId;
    private final int arrivalTime;
    private final int parkingDuration;

    public Car(int gateId, int carId, int arrivalTime, int parkingDuration)
    {
        this.gateId = gateId;
        this.carId = carId;
        this.arrivalTime = arrivalTime;
        this.parkingDuration = parkingDuration;
    }

    public int getId()
    {
        return carId;
    }

    public int getArrivalTime()
    {
        return arrivalTime;
    }

    public int getParkingDuration()
    {
        return parkingDuration;
    }

    public int getGateId()
    {
        return gateId;
    }

    @Override
    public String toString() {
        return "Car " + carId + " from Gate " + gateId;
    }
}
