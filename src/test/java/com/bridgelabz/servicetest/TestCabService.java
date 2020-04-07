package com.bridgelabz.servicetest;

import com.bridgelabz.serivice.CabService;
import com.bridgelabz.utility.InvoiceSummary;
import com.bridgelabz.utility.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCabService {
    CabService normalCabService = new CabService(CabService.RideType.NORMAL_RIDE);

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double totalFare = normalCabService.calculateYourFare(10, 30.1);
        Assert.assertEquals(130.1, totalFare, 1);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double totalFare = normalCabService.calculateYourFare(0.1, 1);
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary summary = normalCabService.calculateYourFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(summary, expectedInvoiceSummary);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10)};
        InvoiceSummary summary = normalCabService.calculateYourFare(rides);
        Assert.assertEquals(85, summary.totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryNumberOfRide() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10),
                new Ride(3, 5)};
        InvoiceSummary summary = normalCabService.calculateYourFare(rides);
        Assert.assertEquals(3, summary.numOfRides, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryAverageFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10),
                new Ride(3, 5)};
        InvoiceSummary summary = normalCabService.calculateYourFare(rides);
        Assert.assertEquals(40, summary.averageFare, 0);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "Yoyo12";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10),
                new Ride(3, 5)};
        normalCabService.addRides(userId, rides);
        InvoiceSummary summary = normalCabService.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(3, 120);
        Assert.assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenPremiumRides_ShouldReturnPremiumInvoiceSummary() {
        CabService premiumCabService = new CabService(CabService.RideType.PREMIUM_RIDE);
        String userId = "Yoyo12";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10),
                new Ride(3, 5)};
        premiumCabService.addRides(userId, rides);
        InvoiceSummary summary = premiumCabService.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(3, 190);
        Assert.assertEquals(expectedSummary, summary);
    }
}
