package com.baarsch_bytes;

public class MathUtils {

    boolean inRange(int x, int min, int max, boolean flag) {
        return flag
                && max >= min
                && x >= min
                && x <= max;
    }





}
