package org.os;
import java.util.*;
import java.util.concurrent.*;

public class ParkingSimulation
{
    public static void main(String[] args)
    {
        List<Car> cars = InputReader.readCarData("input.txt");
        ParkingLot parkingLot = new ParkingLot();

        CountDownLatch latch = new CountDownLatch(cars.size());

        for (Car car : cars)
        {
            new Thread(() ->
            {
                try
                {
                    Thread.sleep(car.getArrivalTime() * 1000L);
                    System.out.println(car + " arrived at time " + car.getArrivalTime());
                    parkingLot.simulateCarParking(car);  // Park the car
                    Thread.sleep(car.getParkingDuration() * 1000L);
                    parkingLot.leaveParking(car);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
                finally
                {
                    latch.countDown();
                }
            }).start();
        }

        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }

        parkingLot.printSummary();
    }
}


