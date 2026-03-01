package com.baarsch_bytes;

public class TestCases {

    public static String testCase1 = "39.9, true, false";
    public static String testCase2 = "40.0, true, true";
    public static String testCase3 = "50, false, false";

    public static final String[] testCases1 =
            {       "39.9, true, false",    // trainingHours, testPassed, expectedResult
                    "40.0, true, true",
                    "50, false, false"
            };
    public static String[] testCases2 =
            {       testCase1,
                    testCase2,
                    testCase3
            };

}
