package com.bridgelabz.serivice;

import com.bridgelabz.adaptor.IInvoiceGenerator;
import com.bridgelabz.adaptor.InvoiceFactory;
import com.bridgelabz.utility.InvoiceSummary;
import com.bridgelabz.utility.Ride;

public class CabService {

    IInvoiceGenerator invoiceCalculator = InvoiceFactory.getInvoiceData();

    public double calculateYourFare(double distance, double time) {
        Double totalFare = invoiceCalculator.calculateFare(distance, time);
        return totalFare;
    }

    public InvoiceSummary calculateYourFare(Ride[] rides) {
        Double totalFare = invoiceCalculator.calculateFare(rides);
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        invoiceCalculator.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return invoiceCalculator.getInvoiceSummary(userId);
    }
}
