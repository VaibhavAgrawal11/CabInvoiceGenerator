package com.bridgelabz.servicetest;

import com.bridgelabz.serivice.CabService;
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
    public void test2() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        double totalFare = cabService.calculateYourFare(rides);
        Assert.assertEquals(30, totalFare, 0);
    }
}
