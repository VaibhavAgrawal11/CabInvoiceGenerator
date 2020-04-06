package com.bridgelabz.adaptor;

import com.bridgelabz.utility.Ride;

public interface IInvoiceGenerator {
    public double calculateFare(double distance, double time);

    public double calculateFare(Ride[] rides);
}
