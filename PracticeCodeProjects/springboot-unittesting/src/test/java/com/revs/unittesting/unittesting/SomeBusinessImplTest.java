package com.revs.unittesting.unittesting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplTest {

    @Mock
    SomeDataService someDataService;

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @BeforeTestClass
    public void beforeTestClass() {
        System.out.println("Before Test Class");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before Each Method");
    }

    @Test
    void testCalculateSum_ForRealIntegers() {
        // given
        int[] data = {1,2,3,4,5};
        int expectedSum = 15;

        // when
        int actualSum = someBusiness.calculateSum(data);

        // then
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testCalculateSum_ForEmptyIntArray() {
        // given
        int[] data = {};
        int expectedSum = 0;

        // when
        int actualSum = someBusiness.calculateSum(data);

        // then
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testCalculateSum_ForOneValue() {
        // given
        int[] data = {5};
        int expectedSum = 5;

        // when
        int actualSum = someBusiness.calculateSum(data);

        // then
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testCalculateSumOfDataService_SomeData() {
        // given
        int[] data = {1,8,9};
        when(someDataService.getData()).thenReturn(data);

        // when
        int actualSum = someBusiness.calculateSumOfDataService();

        // then
        assertEquals(18, actualSum);

    }
}