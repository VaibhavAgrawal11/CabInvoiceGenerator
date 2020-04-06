package com.bridgelabz.adaptor;

import com.bridgelabz.utility.Ride;

public class InvoiceGeneratorImpl implements IInvoiceGenerator {
    private static final double MINIMUM_Fare = 5;
    private static final double COST_PER_KILOMETER = 10;
    private static final double COST_PER_TIME = 1;
    private double totalFare;

    @Override
    public double calculateFare(double distance, double time) {
        totalFare = distance * COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_Fare);
    }

    @Override
    public double calculateFare(Ride[] rides) {
        for (Ride ride : rides)
            totalFare += this.calculateFare(ride.distance,ride.time);
        return totalFare;
    }
}
