package com.bridgelabz.servicetest;

import com.bridgelabz.serivice.CabService;
import org.junit.Assert;
import org.junit.Test;

public class TestCabService {
    CabService cabService = new CabService();
    @Test
    public void test() {
       double totalFare = cabService.calculateYourFare(10,30.1);
        Assert.assertEquals(135.1,totalFare,1);
    }
}
