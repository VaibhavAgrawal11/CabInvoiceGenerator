package com.bridgelabz.adaptor;

public class InvoiceGeneratorImpl implements IInvoiceGenerator {
    private double minimumFare=5;
    private double totalFare=0;
    @Override
    public double calculateFare(double distance, double time) {
        this.totalFare = minimumFare + distance * 10 + time;
        return totalFare;
    }
}
