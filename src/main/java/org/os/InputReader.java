package org.os;
import java.io.*;
import java.util.*;

public class InputReader
{
    public static List<Car> readCarData(String filePath)
    {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",\\s*");
                int gateId = Integer.parseInt(parts[0].split(" ")[1]);
                int carId = Integer.parseInt(parts[1].split(" ")[1]);
                int arrivalTime = Integer.parseInt(parts[2].split(" ")[1]);
                int parkingDuration = Integer.parseInt(parts[3].split(" ")[1]);


                cars.add(new Car(gateId, carId, arrivalTime, parkingDuration));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return cars;
    }
}
