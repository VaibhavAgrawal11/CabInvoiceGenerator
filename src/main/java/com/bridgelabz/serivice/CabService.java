package com.bridgelabz.serivice;

import com.bridgelabz.adaptor.IInvoiceGenerator;
import com.bridgelabz.adaptor.InvoiceFactory;

public class CabService {
    public double calculateYourFare(double distance, double time){
        IInvoiceGenerator invoiceCalculator = InvoiceFactory.getInvoiceData();
        return invoiceCalculator.calculateFare(distance,time);
    }
}
