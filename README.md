# Parking System Simulation using Semaphores and Threads

## Overview
This Java-based parking system simulates a parking lot with limited spots and three gates through which cars can enter. The system uses threads to simulate car arrivals and departures and utilizes semaphores for synchronization to manage parking spots.

## Objectives
- **Thread Synchronization**: Use semaphores to manage access to limited parking spots.
- **Concurrency Management**: Ensure that the system handles concurrent arrivals and departures without errors.
- **Simulation Realism**: Simulate cars arriving at different times and staying for a predetermined duration.
- **Status Reporting**: Report the number of cars currently parked and the total number of cars served over time.

## System Specifications
- **Parking Spots**: 4 available spots.
- **Gates**: 3 gates (Gate 1, Gate 2, Gate 3).
- **Input**: Read car arrival and parking duration from an input file.
- **Concurrency**: Handle concurrent arrivals and departures using threads and semaphores.

## Implementation Details
The system simulates a parking lot with:
1. 4 parking spots (Semaphore for managing availability).
2. 3 gates where cars arrive at different times.
3. Each car is represented by a thread and is managed by the parking semaphore to synchronize entry and exit.
4. **Input** is parsed from a text file that defines the arrival times and parking durations for each car.

## Technologies Used
- **Java**: For creating threads, semaphores, and managing the parking system logic.
- **Semaphores**: For controlling concurrent access to parking spots.
- **Threading**: For simulating car arrival times and parking duration.
