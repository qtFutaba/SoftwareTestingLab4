package com.baarsch_bytes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class LicenserTest {

    private Licenser licenser;

    public static final String testCase1 = "39.9, true, false";
    public static final String testCase2 = "40.0, true, true";
    public static final String testCase3 = "50, false, false";


    @BeforeEach
    void testSetup(){
        licenser = new Licenser();
    }

    //@CsvSource(TestCases.testCases1)
/*
    @ParameterizedTest
    //@CsvFileSource(resources="/Book1.csv")
    @CsvSource({
            "39.9, true, false",    // trainingHours, testPassed, expectedResult
            "40.0, true, true",
            "50, false, false"
    })
    */
    @ParamTest
    void testTrainingHoursAndTestPassed(double trainingHours, boolean testPassed, boolean expectedResult) {
        assertEquals(expectedResult,
                licenser.issueLicense(trainingHours, testPassed),
                "Failed at: \nhours: " + trainingHours + "\ntestPassed: " + testPassed);
    }
/*

    @Test
    public void testIssueLicense_Success() {
        boolean result = licenser.issueLicense(40.0, true);

        assertTrue(result, "License should be issued when hours >= 40 and test is passed");
    }

    @Test
    void testIssueLicense_FailsDueToHours() {
        // Act
        boolean result = licenser.issueLicense(39.9, true);
        // Assert
        assertFalse(result, "License should not be issued if hours are less than 40.");
    }

    @Test
    void testIssueLicense_FailsDueToTest() {
        // Act
        boolean result = licenser.issueLicense(50.0, false);
        // Assert
        assertFalse(result, "License should not be issued if the test was not passed.");
    }
*/

}
