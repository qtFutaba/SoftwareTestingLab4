package com.baarsch_bytes;

import com.baarsch_bytes.Exceptions.ReservationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReserveMyParkTest {

    @ParameterizedTest
    @CsvFileSource(resources="/reserveMyPark_tests.csv", numLinesToSkip = 1)
    void testCalculateStayPriceNonError(String testCase, int nights, int age, boolean isResident,
                                boolean isVeteran, double expectedReturn) throws Exception{
        ReserveMyPark reserver = new ReserveMyPark();

        assertEquals(expectedReturn, reserver.calculateStayPrice(nights, age, isResident,
                isVeteran), "Reserve My Park testCase " + testCase + " failed. ");
    }

    @ParameterizedTest
    @CsvFileSource(resources="/reserveMyPark_errorTests.csv", numLinesToSkip = 1)
    void testCalculateStayPriceErrors(String testCase, int nights, int age, boolean isResident,
                                      boolean isVeteran, String exception) throws ClassNotFoundException {
        ReserveMyPark reserver = new ReserveMyPark();

        Class<? extends Throwable> exceptionClass =  (Class<? extends Throwable>) Class.forName(exception);
        assertThrows(exceptionClass, () -> {
            reserver.calculateStayPrice(nights, age, isResident, isVeteran);
        }, "Reserve My Park test case " + testCase + " failed.");

    }



}
