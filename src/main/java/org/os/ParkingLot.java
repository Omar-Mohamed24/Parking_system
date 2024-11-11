package org.os;
import java.util.concurrent.*;
import java.util.*;

public class ParkingLot
{
    private final Semaphore parkingSpots;
    private final int totalSpots = 4;
    private final Map<Integer, Integer> carsInLot;
    private final Map<Integer, Integer> carsServedAtGate;
    private int totalCarsServed;

    public ParkingLot()
    {
        this.parkingSpots = new Semaphore(totalSpots, true);
        this.carsInLot = new HashMap<>();
        this.carsServedAtGate = new HashMap<>();
        this.totalCarsServed = 0;
    }

    public boolean parkCar(Car car) throws InterruptedException
    {
        boolean acquired = parkingSpots.tryAcquire();
        if (acquired)
        {
            carsInLot.put(car.getId(), car.getParkingDuration());
            carsServedAtGate.put(car.getGateId(), carsServedAtGate.getOrDefault(car.getGateId(), 0) + 1);
            totalCarsServed++;
            System.out.println("Car " + car.getId() + " from Gate " + car.getGateId() + " parked. (Parking Status: " + (totalSpots - parkingSpots.availablePermits()) + " spots occupied)");
            return true;
        }
        else
        {
            System.out.println("Car " + car.getId() + " from Gate " + car.getGateId() + " waiting for a spot.");
            return false;
        }
    }

    public void leaveParking(Car car)
    {
        carsInLot.remove(car.getId());
        parkingSpots.release();
        System.out.println("Car " + car.getId() + " from Gate " + car.getGateId() + " left after " + car.getParkingDuration() + " units of time. (Parking Status: " + (totalSpots - parkingSpots.availablePermits()) + " spots occupied)");
    }

    public void simulateCarParking(Car car) throws InterruptedException
    {
        boolean parked = false;
        while (!parked)
        {
            parked = parkCar(car);
            if (!parked)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void printSummary()
    {
        System.out.println("Total Cars Served: " + totalCarsServed);
        System.out.println("Current Cars in Parking: " + (totalSpots - parkingSpots.availablePermits()));

        System.out.println("Details:");
        for (Map.Entry<Integer, Integer> entry : carsServedAtGate.entrySet())
        {
            System.out.println("Gate " + entry.getKey() + " served " + entry.getValue() + " cars.");
        }
    }
}
