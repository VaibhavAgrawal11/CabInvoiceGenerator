package com.bridgelabz.adaptor;

import com.bridgelabz.serivice.CabService;
import com.bridgelabz.utility.InvoiceSummary;
import com.bridgelabz.utility.Ride;
import com.bridgelabz.utility.RideRepository;

public class InvoiceGeneratorImpl implements IInvoiceGenerator {
    private static double MINIMUM_FARE;
    private static double COST_PER_KILOMETER;
    private static double COST_PER_TIME;
    private double totalFare;
    private RideRepository rideRepository = new RideRepository();

    public InvoiceGeneratorImpl(CabService.RideType rideType) {
        if(rideType.equals(CabService.RideType.PREMIUM_RIDE))
        {
            this.MINIMUM_FARE = 20;
            this.COST_PER_KILOMETER = 15;
            this.COST_PER_TIME = 2;
        }
        if(rideType.equals(CabService.RideType.NORMAL_RIDE)){
            this.MINIMUM_FARE = 5;
            this.COST_PER_KILOMETER = 10;
            this.COST_PER_TIME = 1;
        }
    }

    @Override
    public double calculateFare(double distance, double time) {
        totalFare = distance * COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    @Override
    public double calculateFare(Ride[] rides) {
        for (Ride ride : rides)
            totalFare += this.calculateFare(ride.distance, ride.time);
        return totalFare;
    }

    @Override
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    @Override
    public InvoiceSummary getInvoiceSummary(String userId) {
        double totalFare = this.calculateFare(rideRepository.getRides(userId));
        return new InvoiceSummary(rideRepository.getRides(userId).length, totalFare);
    }
}
