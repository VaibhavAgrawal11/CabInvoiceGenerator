package com.bridgelabz.servicetest;

import com.bridgelabz.serivice.CabService;
import com.bridgelabz.utility.InvoiceSummary;
import com.bridgelabz.utility.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCabService {
    CabService cabService = null;

    @Before
    public void setUp() throws Exception {
        cabService = new CabService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double totalFare = cabService.calculateYourFare(10, 30.1);
        Assert.assertEquals(130.1, totalFare, 1);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double totalFare = cabService.calculateYourFare(0.1, 1);
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary summary = cabService.calculateYourFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(summary, expectedInvoiceSummary);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10)};
        InvoiceSummary summary = cabService.calculateYourFare(rides);
        Assert.assertEquals(85, summary.totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryNumberOfRide() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10),
                new Ride(3, 5)};
        InvoiceSummary summary = cabService.calculateYourFare(rides);
        Assert.assertEquals(3, summary.numOfRides, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryAverageFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10),
                new Ride(3, 5)};
        InvoiceSummary summary = cabService.calculateYourFare(rides);
        Assert.assertEquals(40, summary.averageFare, 0);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "Yoyo12";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5, 10),
                new Ride(3, 5)};
        cabService.addRides(userId,rides);
        InvoiceSummary summary = cabService.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(3,120);
        Assert.assertEquals(expectedSummary,summary);
    }
}
