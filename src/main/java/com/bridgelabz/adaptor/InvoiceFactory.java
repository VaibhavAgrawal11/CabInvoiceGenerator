package com.bridgelabz.adaptor;

import com.bridgelabz.serivice.CabService;

public class InvoiceFactory {

    public static IInvoiceGenerator getInvoiceData(CabService.RideType rideType) {
        IInvoiceGenerator iInvoiceGenerator = new InvoiceGeneratorImpl(rideType);
        return iInvoiceGenerator;
    }
}
