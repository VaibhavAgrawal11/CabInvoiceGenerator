package com.bridgelabz.serivice;

import com.bridgelabz.adaptor.IInvoiceGenerator;
import com.bridgelabz.adaptor.InvoiceFactory;
import com.bridgelabz.utility.InvoiceSummary;
import com.bridgelabz.utility.Ride;

public class CabService {

    public enum RideType {NORMAL_RIDE, PREMIUM_RIDE}

    private RideType rideType;

    public CabService() {
    }

    public CabService(RideType rideType) {
        this.rideType = rideType;
        invoiceCalculator =InvoiceFactory.getInvoiceData(rideType);
    }

    IInvoiceGenerator invoiceCalculator;

    public double calculateYourFare(double distance, double time) {
        Double totalFare = invoiceCalculator.calculateFare(distance, time);
        return totalFare;
    }

    public InvoiceSummary calculateYourFare(Ride[] rides) {
        Double totalFare = invoiceCalculator.calculateFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        invoiceCalculator.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return invoiceCalculator.getInvoiceSummary(userId);
    }
}
