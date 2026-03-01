package com.baarsch_bytes;

public class Licenser {


    boolean issueLicense(double trainingHours, boolean testPassed) {

        if (trainingHours >= 40 && testPassed)
            return true;
        return false;
    }
}
