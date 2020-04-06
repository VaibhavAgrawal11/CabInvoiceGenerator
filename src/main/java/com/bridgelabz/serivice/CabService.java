package com.bridgelabz.serivice;

import com.bridgelabz.adaptor.IInvoiceGenerator;
import com.bridgelabz.adaptor.InvoiceFactory;
import com.bridgelabz.utility.Ride;

public class CabService {

    IInvoiceGenerator invoiceCalculator = InvoiceFactory.getInvoiceData();

    public double calculateYourFare(double distance, double time) {
        Double totalFare = invoiceCalculator.calculateFare(distance, time);
        return totalFare;
    }

    public double calculateYourFare(Ride[] rides) {
        Double totalFare = invoiceCalculator.calculateFare(rides);
        return totalFare;
    }
}
