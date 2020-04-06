package com.bridgelabz.adaptor;

public class InvoiceFactory {

    public static IInvoiceGenerator getInvoiceData() {
        IInvoiceGenerator iInvoiceGenerator = new InvoiceGeneratorImpl();
        return iInvoiceGenerator;
    }
}
