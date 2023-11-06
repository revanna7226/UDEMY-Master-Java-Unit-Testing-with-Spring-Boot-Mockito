package com.revs.unittesting.unittesting;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        sum = (int) Arrays.stream(data).asDoubleStream().sum();
        return sum;
    }

    public int calculateSumOfDataService() {
        int sum = 0;
        int[] data = someDataService.getData();
        sum = (int) Arrays.stream(data).asDoubleStream().sum();
        return sum;
    }

}
